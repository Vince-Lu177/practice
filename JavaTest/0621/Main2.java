package Practice_0621;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int change = scanner.nextInt();
        String[] arr = s.split(",");
        int[] coins = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            coins[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(coins);
        int res = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (change == 0) {
                System.out.println(res);
                break;
            }
            res += change / coins[i];
            change %= coins[i];
        }
        //没有输出说明循环结束时，change不等于0；
        for (int i = 0; i < coins.length; i++) {

        }
    }
}
