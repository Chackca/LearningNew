package Framework.MyTomcat.tomcat;

import Framework.MyTomcat.http.MyRequest;
import Framework.MyTomcat.http.MyResponse;
import Framework.MyTomcat.http.MyServlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MyTomcat {

    private int port = 8080;
    private ServerSocket server;

    //存储url路径对应的类
    private Map<String,MyServlet> servletMapping = new HashMap<>();

    Properties properties = new Properties();

    public void init(){
        try {
            //加载web.xml文件，同时初始化ServletMapping对象
            /*String WEB_INF = this.getClass().getResource("/").getPath();
            System.out.println(WEB_INF);*/

            File directory = new File("");//设定为当前文件夹
            String projectPath = directory.getAbsolutePath();//获取当前目录的路径，用\区分，最后不带\
            String str = this.getClass().getPackage().getName();
            String javapath = str.substring(0,str.length()-"tomcat".length());//获得当前MyTomcat包的在项目中的位置
            // \\代表转换为\  最后path代表MyTomcat这个包的路径
            String path = projectPath+"\\src\\main\\java\\"+javapath.replace(".", "\\");

            FileInputStream fis = new FileInputStream( path+ "web.properties");
            properties.load(fis);

            for (Object k : properties.keySet()){
                //将key取出来
                String key = k.toString();
                if (key.endsWith(".url")){
                    //取得key除去.url后的值，原来为servlet.one.url，后来为servlet.one
                    String servletName = key.replaceAll("\\.url$","");
                    String url = properties.getProperty(key);
                    //组合成另外一个key原来为servlet.one，后来为servlet.one.class，className代表该类的全限定名位置
                    String className = properties.getProperty(servletName+".className");
                    MyServlet obj = (MyServlet)Class.forName(className).newInstance();

                    servletMapping.put(url,obj);
                }


            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    private void process(Socket client) throws Exception{
        //3、获取到socket对象，将socket。getInputStream()封装成request
        //                   将socket。getOutputStream()response
        InputStream is = client.getInputStream();
        OutputStream out = client.getOutputStream();
        MyRequest request = new MyRequest(is);
        MyResponse response = new MyResponse(out);


        //4、实现动态调用doGet/doPost方法，并且能够自定义返回结果
        //想办法拿到用户所请求的URL
        String url = request.getUrl();
        if (servletMapping.containsKey(url)) {
            servletMapping.get(url).service(request, response);
        }else {
            response.write("404 - NOT FOUND");
        }

        out.flush();
        out.close();
        //为什么要关闭client，因为http请求都是采用短链接
        client.close();
    }

    public void start(){

        //1、加载配置文件，初始化servletMapping
        init();

        try {
            server = new ServerSocket(this.port);

            System.out.println("MyTomcat 已启动，监听的端口为"+this.port);

            //2、等待用户请求,用一个死循环
            while (true){
                Socket client = server.accept();

                process(client);

                //OutputStream os = socket.getOutputStream();
                //os.write("Hello".getBytes());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new MyTomcat().start();
    }

}
