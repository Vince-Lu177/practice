package Practice_0617;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        if (x < 1 || x > 1000000006) {
            System.out.println(-1);
        }
        int m = x + 1;
        int n = 0;
        for (int i = 1; i < 1000000006; i++) {
            if (getNum1((i * 1000000007l + 1) / m)) {
                long c = i * 1000000007l + 1;
                n = getNum2(c/m);
                break;
            }
        }
        if (n / 3 > 1000000006) {
            System.out.println(-1);
        }
        if(n == 1){
            System.out.println(-1);
        }
        if (n % 3 == 0) {
            System.out.println(n / 3);
        } else {
            System.out.println(n / 3 + 1);
        }
    }

    private static boolean getNum1(double num) {
        while (num >= 1.0) {
            if (num == 1.0) {
                return true;
            } else {
                num /= 2.0;
            }
        }
        return false;
    }

    private static int getNum2(long num) {
        int count = 0;
        while (num >= 1) {
            if (num == 1) {
                return count;
            } else {
                num /= 2;
                count++;
            }
        }
        return -1;
    }
}
