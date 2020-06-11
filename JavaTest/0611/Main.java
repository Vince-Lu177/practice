package Practice_0611;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String M = scanner.next();
        String[] strings = M.split("");
        Map<String,Integer> map = new HashMap<>() ;
        for(String  s: strings){
            Integer value = map.get(s);
            if(value == null){
                map.put(s,1);
            }else{
                map.put(s,value + 1);
            }
        }
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
