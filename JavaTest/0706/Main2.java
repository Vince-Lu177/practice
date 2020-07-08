package Practice_0706;

import java.util.Scanner;

public class Main2 {



    public static void main(String[] args) {
         int anInt = 29;
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] arr1 = s.split(" ");
        String[] arr2 = arr1[0].split("\\.");
        String[] arr3 = arr1[1].split("\\.");
        //应付
        int a = Integer.parseInt(arr2[0]) * 17 * anInt +
                Integer.parseInt(arr2[1]) * anInt + Integer.parseInt(arr2[2]);
        //实带
        int b = Integer.parseInt(arr3[0]) * 17 * anInt +
                Integer.parseInt(arr3[1]) * anInt + Integer.parseInt(arr3[2]);
        int res1 = b - a;
        if (res1 >= 0) {
            int m = res1 / (17 * anInt);
            int n = res1 % (17 * anInt) / anInt;
            int k = res1 % (17 * anInt) % anInt;
            String res = m + "." + n + "." + k;
            System.out.println(res);
        } else {
            res1 = -res1;
            int m = res1 / (17 * anInt);
            int n = res1 % (17 * anInt) / anInt;
            int k = res1 % (17 * anInt) % anInt;
            String res = "-" + m + "." + n + "." + k;
            System.out.println(res);
        }
    }
}
