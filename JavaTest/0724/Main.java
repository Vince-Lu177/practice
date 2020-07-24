package Practice_0724;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arr = new String[Integer.parseInt(str)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextLine();
        }
        int[] arr2 = new int[arr.length];
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            String[] arr3 = arr[i].split(" ");
            map.put(arr3[2]+i,Integer.parseInt(arr3[1]));
            arr2[i] = Integer.parseInt(arr3[2]);
        }
        Arrays.sort(arr2);
        int count = 0;
        for (int i = arr2.length-1; i >= 1; i--) {
            int lastValue = map.get(arr2[i-1]);
            int curValue = map.get(arr2[i]);
            if(curValue<=lastValue){
                count++;
            }
        }
        System.out.println(count);
    }
}
