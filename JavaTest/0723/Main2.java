package Practice_0723;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Integer> map = new HashMap<>();
        while(scanner.hasNextLine()){
            String str = scanner.nextLine();
            if(str == ""){
                break;
            }
            int count = 0;
            Integer value = map.get(str);
            if(value == null){
                map.put(str,1);
                count++;
                if(count>=8){
                    break;
                }
            }else{
                map.put(str,value+1);
            }

        }
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getKey().length()>16){
                System.out.println(entry.getKey().substring(entry.getKey().length()-16)+" "+entry.getValue());
            }else{
                System.out.println(entry.getKey()+" "+entry.getValue());

            }
        }
    }
}
