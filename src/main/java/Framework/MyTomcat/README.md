# 手写SpringMVC介绍

## 流程：

### web.properties
告诉web容器，浏览器的url和业务对象进行一个关联，相当于一个注册作用

    servlet.one.url=/oneServlet.do
    servlet.one.className=Framework.MyTomcat.servlet.OneServlet
    
上面分别配置方法名，下面对应具体的Servlet的位置，用户每新建一个servlet需要在这里进行注册

### 项目目录
- MyTomcat
  - http
    - MyRequest
    - MyResponse
    - MyServlet
  - servlet
    - OneServlet
    - TwoServlet
  - tomcat
    - MyTomcat

### 书写流程
- MyTomcat.java
    - 准备一个main主方法，主方法调用start方法
    - start()逻辑：init()加载配置文件web.properties，用一个Map<String,MyServlet> servletMapping来存储url对应的自定义的servlet的类，存储的类是已经实例化了的类
    - 创建一个socket用来监听本机端口，设置为8080，调用其accept()等待用户请求
    - 调用process(Socket client)，通过client创建InputStream与OutputStream对象，再创建自己定义的request与response对象，分别传入上面的流

- MyRequest.java
    - 内部含有String method，String url参数
    - 构造方法接收一个InputStream is对象，构造方法内部通过is取得请求头，分析出请求头的方法类型与请求路径存储在类内部的参数里面
    
- MyTomcat.java（续上面）
    - 取得上面创建的request内部的url，检查servletMapping里面有没有这个url，有的话调用其对应的对象(oneServlet)的service方法
    
- MyServlet.java（抽象类）
    - 内部含有具体service方法，抽象的doGet、doPost，service方法通过判断传入的request的方法是否为get来决定调用doGet还是doPost
     
- OneServlet.java（自定义的逻辑类，继承MyServlet）
    - 内部实现了doGet与doPost，doGet调用doPost，doPost里面书写具体的逻辑
    
- MyTomcat.java（续上面）
    - 上面调用了service方法后，也就是判断调用doGet还是doPost，然后由于MyServlet是抽象的，所以会去调用具体类(OneServlet)的doGet、doPost方法