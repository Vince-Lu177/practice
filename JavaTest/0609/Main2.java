package Practice_0609;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n < 1 || n > 1000) {
            System.out.println(-1);
        }
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (i % 5 == 0 && i != 10 && i != 25 && i != 50 && i != 100 && i != 125 && i != 250 && i != 500 && i != 1000) {
                count++;
                continue;
            }
            if (i % 10 == 0 && i != 50 && i != 100 && i != 250 && i != 500 && i != 1000) {
                count++;
                continue;
            }
            if (i % 25 == 0 && i != 50 && i != 100 && i != 125 && i != 250 && i != 500 && i != 1000) {
                count += 2;
                continue;
            }
            if (i % 50 == 0 && i != 100 && i != 250 && i != 500 && i != 1000) {
                count += 2;
                continue;
            }
            if (i % 100 == 0 && i != 500 && i != 100) {
                count += 2;
                continue;
            }
            if (i % 125 == 0 && i != 250 && i != 500 && i != 1000) {
                count += 3;
                continue;
            }
            if (i % 250 == 0 && i != 500 && i != 1000) {
                count += 3;
                continue;
            }
            if (i % 500 == 0) {
                count += 3;
                continue;
            }
        }
        System.out.println(count);
    }
}
