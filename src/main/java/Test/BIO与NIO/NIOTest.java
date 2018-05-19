package Test.BIO与NIO;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOTest {

    private static int port = 8000;

    private static InetSocketAddress address = null;

    private static Selector selector;

    private static ByteBuffer buffer= ByteBuffer.allocate(1024);

    public static void main(String[] args) throws IOException {

        address = new InetSocketAddress(port);

        //channel的多路复用
        ServerSocketChannel server = ServerSocketChannel.open();

        //监听一个端口
        server.bind(address);

        //需要把这个channel设置成非阻塞
        server.configureBlocking(false);

        //初始化selector
        selector = Selector.open();

        //把channel路和selector关联上
        //表示客户端可以进行连接了
        server.register(selector, SelectionKey.OP_ACCEPT);

        while (true){
            int count = selector.select();
            if (count == 0)
                continue;
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                //拿到这个key就需要对这个key进行操作，后续的操作
                process(key);
                iterator.remove();
            }
        }

    }
    //接下来根据key进行连接的创建，读写操作
    private static void process(SelectionKey key) throws IOException {
        //判断这个key SelectionKeys的状态，可以接收，可读写
        if (key.isAcceptable()){
            //创建连接对象，客户端对象   下面是代表服务端的channel
            ServerSocketChannel server = (ServerSocketChannel)key.channel();
            SocketChannel client = server.accept();
            client.configureBlocking(false);
            //要对这个key进行另外一个注册
            client.register(selector,SelectionKey.OP_READ);

        }else if (key.isReadable()){
            //读取客户端的数据
            //根据客户端进行接下来的操作   把客户端传来的数据读到buffer中
            SocketChannel client = (SocketChannel)key.channel();
            int len = client.read(buffer);
            if (len>0){
                buffer.flip();//锁定 对缓冲区里面的数据进行确定
                String text = new String(buffer.array(),0,len);
                System.out.println(text);
            }

            //读完之后，你需要再告诉服务大厅的选择器
            client.register(selector,SelectionKey.OP_WRITE);
            buffer.clear();
        }else if (key.isWritable()){
            SocketChannel client = (SocketChannel)key.channel();
            client.write(buffer.wrap("恭喜你，取到钱了".getBytes()));
            client.close();
        }
    }
}
