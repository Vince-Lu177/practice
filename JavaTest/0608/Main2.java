package Practice_0608;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] strings1 = s.split(" ");
        int n = Integer.parseInt(strings1[strings1.length - 1]);
        String s2 = s.substring(0,s.length() - 1);
        String[] strings2 = s2.split(" ");
        int[] arr = new int[strings2.length];
        for (int i = 0; i < strings2.length; i++) {
            arr[i] = Integer.parseInt(strings2[i]);
        }
        if(n <= 0 || n > arr.length){
            return;
        }
        Arrays.sort(arr);
        StringBuilder result = new StringBuilder(arr[0] + " ");
        for (int i = 1; i < n; i++) {
            result.append(arr[i]).append(" ");
        }
        System.out.println(result);
    }
}
