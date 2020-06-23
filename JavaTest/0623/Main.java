package Practice_0623;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static int getValue(int[] gifts, int n) {
        // write code here
        Map<Integer,Integer> map = new HashMap<>();
        for(Integer x : gifts){
            Integer count = map.get(x);
            if(count == null){
                map.put(x,0);
            }else{
                map.put(x,count+1);
            }
        }

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
  //          System.out.println(map.entrySet());
            if(entry.getValue()>=n/2){
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,2,3};
        System.out.println(getValue(arr,5));
    }
}
