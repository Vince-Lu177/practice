package game;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.UUID;

//表示一个房间
//每两个玩家构成一个房间，由于服务器的玩家很多
//此时程序中就会存在多个房间实例(不是单例)
public class Room {
    private String roomId;
    private int playerId1;
    private int playerId2;

    //房间除了需要记录玩家信息之外，还需要记录游戏状态
    //使用二维数组来表示棋盘当前的状态
    private static final int MAX_ROW = 15;
    private static final int MAX_COL = 15;
    //棋盘中的每个元素都是整数
    //0->空
    //1->玩家1
    //2->玩家2
    private int[][] chessBoard = new int[MAX_ROW][MAX_COL];

    private Gson gson = new GsonBuilder().create();

    public Room() {
        //保证房间的唯一性，
        roomId = UUID.randomUUID().toString();
    }

    public int getPlayerId1() {
        return playerId1;
    }

    public int getPlayerId2() {
        return playerId2;
    }

    public void setPlayerId1(int playerId1) {
        this.playerId1 = playerId1;
    }

    public void setPlayerId2(int playerId2) {
        this.playerId2 = playerId2;
    }

    public String getRoomId() {
        return roomId;
    }
}
