package game;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

//通过这个类处理websocket的相关通信逻辑
@ServerEndpoint(value = "/game/{userId}")
public class GameAPI {
    //这个类表示服务器收到的websocket请求
    //匹配请求，只使用type和userId,其他的都是null
    //落子请求，全部使用
    static class Request{
        public String type;
        public int userId;
        public String roomId;
        public int row;
        public int col;
    }
    private int userId;

    @OnOpen
    public void onOpen(@PathParam("userId") String userIdStr, Session session){
        userId = Integer.parseInt(userIdStr);
        System.out.println("玩家建立连接: " + userId);

        // 把玩家加入到在线列表中
        OnlineUserManager.getInstance().online(userId,session);
    }

    @OnClose
    public void onClose(){
        System.out.println("玩家断开连接: " + userId);

        // 把玩家从在线列表中删除
        OnlineUserManager.getInstance().offline(userId);
    }

    @OnError
    public void onError(Session session,Throwable error){
        System.out.println("玩家断开连接: " + userId);
        // 把玩家从在线列表中删除
        OnlineUserManager.getInstance().offline(userId);
        error.printStackTrace();
    }

    //onMessage收到的请求可能是匹配请求，也可能是落子请求，就需要根据请求的type类型做出区分
    //如果type是startMatch,处理匹配请求
    //如果type是putChess,处理落子请求
    //message 请求的内容是一个JSON结构的字符串，于是就需要针对这里的JSON进行解析，
    @OnMessage
    public void onMessage(String message,Session session) throws InterruptedException {
        System.out.printf("收到玩家 %d 的消息: %s\n",userId,message);

        //实例化Gson对象
        Gson gson = new GsonBuilder().create();
        //把message 这个Json格式的字符串转成了Request对象
        Request request = gson.fromJson(message,Request.class);
        if(request.type.equals("startMatch")){
            //执行匹配逻辑
            //引入新的数据结构，匹配队列
            Matcher.getInstance().addMatchQueue(request);
        }else if(request.type.equals("putChess")){
            //执行落子逻辑
        }else{
            System.out.println("非法的 type 值!" + request.type);
        }
    }
}
