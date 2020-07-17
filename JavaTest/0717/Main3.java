package Practice_0717;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        String[] arr = s2.split(" ");
        int[] arr2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = Integer.parseInt(arr[i]);

        }
        int left = 0;
        for (int i = 0; i < arr2.length; i++) {
            if(arr2[i]<0){
                left++;
            }else{
                break;
            }
        }
        //left指向第一个正数或者末尾
        int res = 0;

        for (int i = left; i < arr2.length-1; i++) {

            if(i == arr2.length-2){
                break;
            }
            int tmp = 0;
            if(arr2[i+1]<0){
                for (int j = i+1; j < arr2.length&&arr2[j]>0; j++) {
                    tmp+=arr2[j];
                }
            }
            if(tmp>=0){
                res+=arr2[i];
            }else{
                break;
            }

        }
        System.out.println(res);
    }
}
