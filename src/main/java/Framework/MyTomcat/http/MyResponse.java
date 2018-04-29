package Framework.MyTomcat.http;

import java.io.OutputStream;

public class MyResponse {

    private OutputStream os ;

    public MyResponse(OutputStream os){
        this.os = os;
    }

    public void write(String outString) throws Exception{
        os.write(outString.getBytes());
    }
}
