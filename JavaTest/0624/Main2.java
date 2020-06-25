package Practice_0624;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextInt()) {
            int monthCount = scanner.nextInt();

            if (monthCount <= 0) {
                System.out.println(0);
                return;
            }
            if (monthCount == 1) {
                System.out.println(1);
                return;
            }
            System.out.println(fib(monthCount));
        }

    }

    private static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
