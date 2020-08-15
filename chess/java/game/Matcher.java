package game;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.websocket.Session;
import java.io.IOException;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

//实现匹配功能，内部管理一个匹配队列
//单例类
public class Matcher {
    private Gson gson = new GsonBuilder().create();

    //表示匹配成功后的响应数据
    public static class MatchResponse{
        public String type;
        public String roomId;
        public boolean isWhite;
        public int otherUserId;
    }
    //实现一个匹配机制
    private BlockingDeque<GameAPI.Request> queue = new LinkedBlockingDeque<>();
    //实现插入到阻塞队列的方法
    public void addMatchQueue(GameAPI.Request request) throws InterruptedException {
        queue.put(request);
    }

    //创建一个扫描线程，尝试进行匹配功能
    //在构造实例时创建该线程
    private Matcher(){
        Thread t  = new Thread(){
            @Override
            public void run() {
                while(true){
                    //辅助完成一次匹配过程
                    handlerMatch();
                }
            }
        };
        t.start();
    }

    private void handlerMatch() {
        try {
            //实现一次匹配
            //1.从阻塞队列中取出两个玩家信息
            //queue 是阻塞队列，队列为空，就会阻塞
            GameAPI.Request player1 = queue.take();
            GameAPI.Request player2 = queue.take();
            System.out.println("匹配到两个玩家: " + player1.userId + "," + player2.userId);
            //2.检查两个玩家是否在线，处理玩家下线的情况，也要处理一下自己匹配到自己的情况；
            //(例如，玩家点了匹配之后，进入队列，关闭页面，再次点击匹配就有可能出现自己匹配到自己的情况)
            //更严格的处理方式，应该是服务器告诉客户端当前自己的状态(空闲，匹配中，游戏中，下线)
            OnlineUserManager manager = OnlineUserManager.getInstance();
            Session session1 = manager.getSession(player1.userId);
            Session session2 = manager.getSession(player2.userId);
            //如果玩家不在线对应的Session就为null
            if(session1 == null){
                queue.put(player2);
                return;
            }
            if(session2 == null){
                queue.put(player1);
                return;
            }
            if(session1 == session2){
                //自己匹配到自己
                queue.put(player1);
                return;
            }
            //3.把两个玩家加入到同一个游戏房间中
            Room room = new Room();
            room.setPlayerId1(player1.userId);
            room.setPlayerId2(player2.userId);
            //引入房间对象,管理房间对象
            RoomManager.getInstance().addRoom(room);

            //4.分别给玩家1发送匹配响应，告诉玩家，匹配成功，队手是谁，房间号是多少
            //按照约定的响应格式，把匹配成功的结果返回给客户端
            MatchResponse response1 = new MatchResponse();
            response1.type = "startMatch";
            response1.roomId = room.getRoomId();
            response1.isWhite = true;
            response1.otherUserId = player2.userId;
            String respJson1 = gson.toJson(response1);
            session1.getBasicRemote().sendText(respJson1);
            //5.分别给玩家2发送匹配响应，告诉玩家，匹配成功，队手是谁，房间号是多少
            //按照约定的响应格式，把匹配成功的结果返回给客户端
            MatchResponse response2 = new MatchResponse();
            response2.type = "startMatch";
            response2.roomId = room.getRoomId();
            response2.isWhite = false;
            response2.otherUserId = player1.userId;
            String respJson2 = gson.toJson(response2);
            session2.getBasicRemote().sendText(respJson2);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

    }


    private static volatile Matcher instance = null;

    public static Matcher getInstance(){
        if(instance == null){
            synchronized (Matcher.class){
                if(instance == null){
                    instance = new Matcher();
                }
            }
        }
        return instance;
    }
}
