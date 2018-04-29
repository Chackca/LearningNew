package Framework.MyTomcat.http;

public abstract class MyServlet {

    public void service(MyRequest req,MyResponse resp) throws Exception{
        //由service方法来决定，是调用doGet还是doPost
        if ("GET".equalsIgnoreCase(req.getMethod())){
            doGet(req,resp);
        }else {
            doPost(req,resp);
        }

    }

    public abstract void doGet(MyRequest req,MyResponse resp) throws Exception;


    public abstract void doPost(MyRequest req,MyResponse resp) throws Exception;


}
