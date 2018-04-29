package Framework.MyTomcat.http;

import java.io.InputStream;
import java.util.Map;

public class MyRequest {

    private String method;
    private String url;

    public MyRequest(InputStream is){

        //获取Http协议请求头
        try {
            String content = "";
            int len = 0;
            byte[] buff = new byte[1024];
            if ((len = is.read(buff))>0){
                content = new String(buff,0,len);
                System.out.println(content);
            }
            //获得第一行的字符串
            String line = content.split("\\n")[0];
            //根据空白字符分割第一行的字符串
            String[] arr = line.split("\\s");

            this.method = arr[0];
            //获得?参数前代表的路径
            this.url = arr[1].split("\\?")[0];

        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public String getMethod(){
        return this.method;
    }

    public String getUrl(){
        return this.url;
    }
    public Map<String,String> getParmenter(){
        return null;
    }
}
