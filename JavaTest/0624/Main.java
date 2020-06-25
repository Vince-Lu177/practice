package Practice_0624;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int monthCount = scanner.nextInt();
        if(monthCount <= 0){
            System.out.println(0);
            return;
        }
        if (monthCount == 1) {
            System.out.println(1);
            return;
        }
        long last1 = 1;
        long last2 = 1;
        long cur = 0;
        for (int i = 2; i < monthCount; i++) {
            cur = last1 + last2;
            last1 = last2;
            last2 = cur;
        }
        System.out.println(cur);
    }
}
