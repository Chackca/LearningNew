package Framework.MySpringMVC.mvcframework.servlet;

import Framework.MySpringMVC.mvcframework.annotation.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static sun.security.krb5.internal.crypto.Nonce.value;

public class MyDispatcherServlet extends HttpServlet{

    //所有的配置信息都存入了properties中
    private Properties properties = new Properties();

    private List<String> classNames = new ArrayList<String>();//这里存储的类的全限定名

    private Map<String,Object> ioc = new HashMap<String,Object>();

    //private Map<String,Method> handlerMapping = new HashMap();

    private List<Handler> handlerMapping = new ArrayList<Handler>();

    //初始化阶段运行的方法
    @Override
    public void init(ServletConfig config) throws ServletException {
        //super.init();
        System.out.println("MyDispatcherServlet的init执行中");

        //1.加载配置文件
        doLoadConfig(config.getInitParameter("contextConfigLocation"));

        //2.根据配置文件扫描所有的相关的类
        doScanner(properties.getProperty("scanPackage"));

        //3.初始化所有的相关的类的实例，并且将其放入到IOC容器之中，也就是Map中
        doInstance();

        //4.实现自动依赖注入
        doAutowried();

        //5.初始化HandlerMapping
        initHandlerMapping();

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        this.doPost(req,resp);
    }

    //6.等待请求，进入运行阶段
    //运行时阶段执行的方法
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        /*String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = url.replace(contextPath,"").replaceAll("/+","+");//左边的/+保证无论用户在网址里面写了多少个斜杆/，都可以访问得到
        if (!handlerMapping.containsKey(url)){
            resp.getWriter().write("404 NOT FOUND");
        }
        Method method = handlerMapping.get(url);
        System.out.println("用户调用了方法："+method);
        //反射的方法，需要两个参数：
        //1、需要拿到这个method的instance
        //2、要拿到实参，从request中取值
        method.invoke();*/
        try {
            doDispatch(req,resp);
        }catch (Exception e){
            //如果匹配过程出现异常，将异常信息打印出去
            resp.getWriter().write("500 Exception,Detail:\r\n" + Arrays.toString(e.getStackTrace()).replaceAll(
                    "\\[|\\]","").replaceAll(",\\s","\r\n"));
        }
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        try {
            Handler handler = getHandler(req,resp);
            if (handler == null){
                //如果没有匹配上，返回404错误
                resp.getWriter().write("404 NOT FOUND");
                return;
            }

            //获取方法的参数列表
            Class<?>[] paramTypes = handler.method.getParameterTypes();

            //保存所有需要自动赋值的参数值
            Object[] paramValues = new Object[paramTypes.length];

            //这是属于J2EE的内容
            Map<String,String[]> params = req.getParameterMap();
            for (Map.Entry<String,String[]> param : params.entrySet()){
                //取出当前参数的值，比如id=23，则取出23
                String value = Arrays.toString(param.getValue()).replaceAll("\\[|\\]","").replaceAll(",\\s",",");
                //如果找到匹配的对象，则开始填充数值，这里的判断为：handler中不包含参数的名字为当前参数名，则跳过，比如不含有id这个参数
                if (!handler.paramIndexMapping.containsKey(param.getKey())) continue;
                int index = handler.paramIndexMapping.get(param.getKey());//否则就是包含，取出用户传进来的这个参数在handler方法里面对应的位置索引
                paramValues[index] = convert(paramTypes[index],value);
            }


            //设置方法的request和response对象
            if (handler.paramIndexMapping.get(HttpServletRequest.class.getName())!=null) {
                int reqIndex = handler.paramIndexMapping.get(HttpServletRequest.class.getName());
                paramValues[reqIndex] = req;
            }
            if (handler.paramIndexMapping.get(HttpServletResponse.class.getName())!=null) {
                int respIndex = handler.paramIndexMapping.get(HttpServletResponse.class.getName());
                paramValues[respIndex] = resp;
            }
            //执行该方法，第一个参数为哪个class对象，第二个参数为含有的参数数组
            handler.method.invoke(handler.controller,paramValues);

        }catch (Exception e){
            throw e;
        }
    }

    private Object convert(Class<?> type,String value){
        //如果参数要求的是Integer类型，则将String类型转换为Integer类型，如果用户传入的是id = aaa，则会在这里抛出异常
        if (Integer.class == type){
            try {
                return Integer.valueOf(value);
            }catch (Exception e){
                System.out.println("参数转换错误，可能是int类型里面包含了非数字字符");
                e.printStackTrace();
            }
        }
        return value;
    }

    private Handler getHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        if (handlerMapping.isEmpty()) return null;

        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = url.replace(contextPath,"").replaceAll("/+","/");
        for (Handler handler : handlerMapping){
            try {
                Matcher matcher = handler.pattern.matcher(url);
                //如果没有匹配上继续下一个匹配
                if (!matcher.matches())
                    continue;
                return handler;
            }catch (Exception e){
                throw e;
            }
        }
        return null;
    }



    private void doLoadConfig(String location) {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(location);

        try {
            properties.load(is);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (is != null){
                try {
                    is.close();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }
    }

    private void doScanner(String packageName) {
        //运行递归扫描
        URL url = this.getClass().getClassLoader().getResource("/"+packageName.replaceAll("\\.","/"));
        File classDir = new File(url.getFile());
        for (File file : classDir.listFiles()){
            if(file.isDirectory()){
                doScanner(packageName+"."+file.getName());
            }else {
                String className = (packageName + "." + file.getName().replace(".class",""));
                classNames.add(className);
            }
        }
    }

    private void doInstance( ) {
        if(classNames.isEmpty()){
            return;
        }
        //如果不为空，将刚刚扫描进来的所有的className初始化
        for (String className : classNames){
            try {
                //根据类的全限定名加载其class文件
                Class<?> clazz = Class.forName(className);
                //接下来进入Bean的实例化阶段
                //ioc容器规则
                //1、key默认用类名首字母小写
                //2、如果用户自定义名字，那么要优先选择用自定义名字
                //3、如果是接口的话，可以巧妙地用接口类型作为key
                if (clazz.isAnnotationPresent(MyController.class)){//添加了MyController注解的类无需考虑括号里面的内容，统一用小写首字母存储
                    String beanName = LowerFirstCase(clazz.getSimpleName());
                    ioc.put(beanName,clazz.newInstance());
                }else if (clazz.isAnnotationPresent(MyService.class)){
                    MyService service = clazz.getAnnotation(MyService.class);
                    String beanName = service.value();//获取括号里面的信息
                    //若为默认值，也就是括号里没有设置名字
                    if ("".equals(beanName.trim())){
                        beanName = LowerFirstCase(clazz.getSimpleName());
                    }
                    Object instance = clazz.newInstance();
                    //找到这个类实现的所有接口，根据接口名字存储多个同样的实现类
                    Class<?>[] interfaces = clazz.getInterfaces();
                    for (Class<?> classes : interfaces){
                        ioc.put(classes.getName(),instance);
                    }
                }else {//案例：检测到当前类文件为一个接口，则跳过
                    continue;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
    //依赖注入
    private void doAutowried( ) {
        if (ioc.isEmpty()) return;
        //1、遍历所有的配置了@Controller，@Service的类
        for (Map.Entry<String,Object> entry : ioc.entrySet()){
            //首先第一步要获取到所有的字段 Field
            //不管是private还是protected还是default都要强制注入
            //2、取出类里面所有的域
            Field[] fields = entry.getValue().getClass().getDeclaredFields();
            //3、遍历每个域
            for (Field field : fields){
                //4、如果该字段没有用@MyAutowried赋值，则跳过该字段
                if (!field.isAnnotationPresent(MyAutowried.class)) continue;

                //5、否则，取出@MyAutowired()这个注解
                MyAutowried myAutowried = field.getAnnotation(MyAutowried.class);
                //6、获得这个注解括号里面的内容
                String beanName = myAutowried.value().trim();
                //7、如果@MyAutowried()括号里面没有设置内容
                if ("".equals(beanName)){
                    //设置名字为域类型的名字。带有具体前缀地址，比如获取到的是IDemoService接口类型
                    beanName = field.getType().getName();
                }
                //要想访问到私有的，或者受保护的，必须强制授权访问
                field.setAccessible(true);

                try {
                    //8、将当前域用ioc容器里面的实例赋上值,也就是依赖注入，给对象注入实现类
                    field.set(entry.getValue(),ioc.get(beanName));//第一个参数为当前类的实例对象，第二个参数为将要给这个域注入的值
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    continue;
                }

            }
        }
    }

    private void initHandlerMapping( ) {
        if (ioc.isEmpty()) return;
        System.out.println("接下来会打印Controller里面的所有方法调用的url");
        //1、遍历ioc容器里面的所有对象
        for (Map.Entry<String,Object> entry: ioc.entrySet()){
            Class<?> clazz = entry.getValue().getClass();
            //2、如果对象是controller注解的则进入
            if (clazz.isAnnotationPresent(MyController.class)){
                String baseUrl = "";//存储url
                //如果这个controller注解旁边还有一个MyRequestMapping注解
                if (clazz.isAnnotationPresent(MyRequestMapping.class)){
                    MyRequestMapping requestMapping = clazz.getAnnotation(MyRequestMapping.class);
                    baseUrl = requestMapping.value();
                }

                Method[] methods = clazz.getMethods();
                //3、遍历controller里面的所有方法
                for (Method method : methods){
                    //不是所有牛奶都叫特仑苏
                    if (!method.isAnnotationPresent(MyRequestMapping.class)) continue;
                    MyRequestMapping requestMapping = method.getAnnotation(MyRequestMapping.class);

//                    String url = (baseUrl + requestMapping.value()).replaceAll("/+", "/");
//                    handlerMapping.put(url,method);
//                    System.out.println("Mapping" + url + "," + method);

                    String regex = ("/" + baseUrl + requestMapping.value()).replaceAll("/+","/");
                    Pattern pattern = Pattern.compile(regex);
                    handlerMapping.add(new Handler(pattern,entry.getValue(),method));
                    System.out.println("Mapping" + regex + "," + method);
                }

            }

        }


    }

    private String LowerFirstCase(String str){
        char[] chars = str.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }


    private class Handler{
        protected Object controller;//保存方法对应的实例
        protected Method method;  //保存映射的文件
        protected Pattern pattern;
        protected Map<String,Integer> paramIndexMapping;//参数顺序，第一个参数为@MyRequestParam()括号里面的值，第二个参数为该参数位于该方法第几个参数

        protected Handler(Pattern pattern,Object controller,Method method){
            this.controller = controller;
            this.method = method;
            this.pattern = pattern;

            paramIndexMapping = new HashMap<String,Integer>();
            putParamIndexMapping(method);
        }

        private void putParamIndexMapping(Method method){
            //提取方法中加了注解的参数
            Annotation[][] param = method.getParameterAnnotations(); //获取该方法的参数，包括不带注解的
            for (int i = 0; i < param.length ; i++){
                for (Annotation a : param[i]){
                    if (a instanceof MyRequestParam){
                        String paramName = ((MyRequestParam) a).value();
                        if (!"".equals(paramName.trim())){
                            paramIndexMapping.put(paramName,i);
                        }
                    }
                }
            }


            //提取方法中的request和response参数
            Class<?>[] paramTypes = method.getParameterTypes();
            for (int i = 0 ; i < paramTypes.length ; i++){
                Class<?> type = paramTypes[i];
                if (type == HttpServletRequest.class ||
                        type == HttpServletResponse.class){
                    paramIndexMapping.put(type.getName(),i);
                }
            }
        }
    }

}
