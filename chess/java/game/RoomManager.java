package game;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

//单例类，负责管理若干个房间
//使用一个hash表把房间存储起来,key->roomId,value->Room对象
public class RoomManager {
    private ConcurrentMap<String,Room> rooms = new ConcurrentHashMap<>();
    public void addRoom(Room room) {
        rooms.put(room.getRoomId(),room);
    }

    public void delete(String roomId){
        rooms.remove(roomId);
    }

    public Room getRoom(String roomId){
        return rooms.get(roomId);
    }
    private static volatile RoomManager instance = null;
    public static RoomManager getInstance(){
        if(instance == null){
            synchronized (RoomManager.class){
                if(instance == null){
                    instance = new RoomManager();
                }
            }
        }
        return instance;
    }

    private RoomManager(){

    }


}
