package Framework.MyTomcat.servlet;

import Framework.MyTomcat.http.MyRequest;
import Framework.MyTomcat.http.MyResponse;
import Framework.MyTomcat.http.MyServlet;

public class TwoServlet extends MyServlet{
    @Override
    public void doGet(MyRequest req, MyResponse resp) throws Exception {
        this.doPost(req,resp);
    }

    @Override
    public void doPost(MyRequest req, MyResponse resp) throws Exception {
        resp.write("This is two Servlet");
    }
}
