package practice.practice.JavaTest;

import java.util.HashMap;
import java.util.Map;

public class Practice {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        map.put("吉吉国王","孙悟空");
        map.put("狼狗","成吉思汗");
        map.put("小明","明世隐");
        map.put("鱼","庄周");
        map.getOrDefault("狐狸","妲己");
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println(map.get("小明"));
        System.out.println(map.get("吉吉国王"));
        System.out.println(map.get("狐狸"));
        System.out.println(map.containsKey("狼狗"));
        System.out.println(map.containsValue("庄周"));
        for(Map.Entry<String,String>entry : map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
