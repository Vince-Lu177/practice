package Practice_0708;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String tatal = scanner.nextLine();
        String left = scanner.nextLine();
        tatal = tatal.toUpperCase();
        left = left.toUpperCase();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < tatal.length(); i++) {
            Character ch = tatal.charAt(i);
            Integer value = map.get(ch);
            if(value == null){
                map.put(ch,1);
            }else{
                map.put(ch,value + 1);
            }
        }

        for (int i = 0; i < left.length(); i++) {
            Character ch = left.charAt(i);
            if(map.containsKey(ch)){
                map.remove(ch);
            }
        }
        for (int i = 0; i < tatal.length(); i++) {
            Character ch = tatal.charAt(i);
            if(map.containsKey(ch)){
                System.out.print(ch+"");
                map.remove(ch);
            }
        }
    }
}
