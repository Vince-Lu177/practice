package Practice_0723;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static int MoreThanHalfNum_Solution(int [] array) {
        if(array.length == 0){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            Integer value = map.get(array[i]);
            if(value == null){
                map.put(array[i],1);
            }else{
                map.put(array[i],value+1);
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > array.length/2){
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,2};
        int[] arr2 = {};
        System.out.println(MoreThanHalfNum_Solution(arr));

        String str = "E:\\V1R2\\product\\fpgadrive.c 1325\n";
        System.out.println(str.substring(str.length()-16));
    }
}
