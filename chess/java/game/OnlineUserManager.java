package game;

import javax.websocket.Session;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

//通过这个类来管理在线用户
//一个程序中不需要不需要多个用户管理器实例，这是一个单例类
//此处以懒汉的方式实现
public class OnlineUserManager {

    //使用一个hash表来保存在线用户信息
    //此处使用concurrentHashMap 保证线程安全
    //key == userId value == session
    //存好这个session之后，就可以随时用这个session和客户端进行通信了
    private ConcurrentMap<Integer, Session> users = new ConcurrentHashMap<>();

    //上线
    public void online(int userId,Session session){
        users.put(userId,session);
    }

    //下线
    public void offline(int userId){
        users.remove(userId);
    }

    //获取信息
    public Session getSession(int userId){
        return users.get(userId);
    }



    private static volatile OnlineUserManager instance = null;
    private OnlineUserManager(){}

    public static OnlineUserManager getInstance(){
        if (instance == null) {
            synchronized (OnlineUserManager.class) {
                if(instance == null){
                    instance = new OnlineUserManager();
                }
            }
        }
        return instance;
    }
}
