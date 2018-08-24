package Test.BIO与NIO.NIO网络聊天室;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**
 * 网络多客户端聊天室
 * 功能1： 客户端通过Java NIO连接到服务端，支持多客户端的连接
 * 功能2：客户端初次连接时，服务端提示输入昵称，如果昵称已经有人使用，提示重新输入，如果昵称唯一，则登录成功，之后发送消息都需要按照规定格式带着昵称发送消息
 * 功能3：客户端登录后，发送已经设置好的欢迎信息和在线人数给客户端，并且通知其他客户端该客户端上线
 * 功能4：服务器收到已登录客户端输入内容，转发至其他登录客户端。
 * 
 * TODO 客户端下线检测
 */
public class ChatRoomServer {

    private Selector selector = null;
    static final int port = 9999;
    private Charset charset = Charset.forName("UTF-8");
    //用来记录在线人数，以及昵称
    private static HashSet<String> users = new HashSet<String>();
    
    private static String USER_EXIST = "system message: user exist, please change a name";
    //相当于自定义协议格式，与客户端协商好
    private static String USER_CONTENT_SPILIT = "#@#";
    
    private static boolean flag = false;
    
    public void init() throws IOException {
        //打开selector
        selector = Selector.open();
        //打开ServerSocketChannel
        ServerSocketChannel server = ServerSocketChannel.open();
        server.bind(new InetSocketAddress(port));
        //非阻塞的方式
        server.configureBlocking(false);
        //将通道注册到选择器上，设置为监听状态
        server.register(selector, SelectionKey.OP_ACCEPT);
        
        System.out.println("Server work on port:"+port+" is listening now...");
        
        while(true) {
            int readyChannels = selector.select();
            if(readyChannels == 0) continue; 
            Set selectedKeys = selector.selectedKeys();  //可以通过这个方法，知道可用通道的集合
            Iterator keyIterator = selectedKeys.iterator();
            while(keyIterator.hasNext()) {
                 //取出事件key
                 SelectionKey sk = (SelectionKey) keyIterator.next();
                 keyIterator.remove();
                 //正式处理逻辑
                 dealWithSelectionKey(server,sk);
            }
        }
    }//select中注册了一直都为OP_ACCEPT状态的ServerSocketChannel，同时注册了状态变化的SocketChannel
    
    public void dealWithSelectionKey(ServerSocketChannel server,SelectionKey sk) throws IOException {
        //当客户端刚刚建立了连接会走入这里
        if(sk.isAcceptable()) {
            //获得一个连接的Socket
            SocketChannel sc = server.accept();
            //非阻塞模式，如果不设置为false的话则效果=BIO
            sc.configureBlocking(false);
            //注册选择器，并设置为读取模式，收到一个连接请求，
            //然后起一个SocketChannel，并注册到selector上，之后这个连接的数据，就由这个SocketChannel处理
            sc.register(selector, SelectionKey.OP_READ);
            
            //将此对应的channel设置为准备接受其他客户端请求
            sk.interestOps(SelectionKey.OP_ACCEPT);//这样其他客户端就又可以连接进来了
            System.out.println("Server is listening from client :" + sc.getRemoteAddress());
            sc.write(charset.encode("Please input your name."));
        }
        //处理来自客户端的数据读取请求
        if(sk.isReadable()) {//当客户端发送信息会走入这里
            //返回该SelectionKey对应的 Channel，其中有数据需要读取
            SocketChannel sc = (SocketChannel)sk.channel(); 
            ByteBuffer buff = ByteBuffer.allocate(1024);
            StringBuilder content = new StringBuilder();
            try {
                while(sc.read(buff) > 0) {
                    buff.flip();
                    content.append(charset.decode(buff));
                }
                System.out.println("Server is listening from client " + sc.getRemoteAddress() + " data rev is: " + content);
                //将此对应的channel设置为准备下一次接受数据
                sk.interestOps(SelectionKey.OP_READ);
            }
            catch (IOException io) {
                sk.cancel();
                if(sk.channel() != null) {
                    sk.channel().close();
                }
            }
            if(content.length() > 0) {
                String[] arrayContent = content.toString().split(USER_CONTENT_SPILIT);
                //注册用户
                if(arrayContent != null && arrayContent.length ==1) {
                    String name = arrayContent[0];
                    if(users.contains(name)) {
                        sc.write(charset.encode(USER_EXIST));
                    } else {
                        users.add(name);
                        int num = OnlineNum(selector);
                        String message = "welcome "+name+" to chat room! Online numbers:"+num;
                        BroadCast(selector, null, message);//except为空，则要把消息发送给发消息的一方
                    }
                } 
                //注册完了，发送消息
                else if(arrayContent != null && arrayContent.length >1){
                    String name = arrayContent[0];
                    String message = content.substring(name.length()+USER_CONTENT_SPILIT.length());
                    message = name + " say " + message;
                    if(users.contains(name)) {
                        //不回发给发送此内容的客户端
                        BroadCast(selector, sc, message);
                    }
                }
            }
            
        }
    }
    
    //TODO 要是能检测下线，就不用这么统计了
    public static int OnlineNum(Selector selector) {
        int res = 0;
        for(SelectionKey key : selector.keys()) {
            Channel targetchannel = key.channel();
            if(targetchannel instanceof SocketChannel) {
                res++;
            }
        }
        return res;
    }
    
    public void BroadCast(Selector selector, SocketChannel except, String content) throws IOException {
        //广播数据到所有的SocketChannel中
        for(SelectionKey key : selector.keys()) {
            Channel targetchannel = key.channel();
            //如果except不为空，不回发给发送此内容的客户端
            if(targetchannel instanceof SocketChannel && targetchannel != except) {
                SocketChannel dest = (SocketChannel)targetchannel;
                dest.write(charset.encode(content));
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        new ChatRoomServer().init();
    }
}