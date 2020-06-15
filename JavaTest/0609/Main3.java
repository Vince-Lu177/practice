package Practice_0609;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n < 1 || n > 1000) {
            System.out.println(-1);
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 625 == 0) {
                count += 4;
                continue;
            }
            if (i % 125 == 0) {
                count += 3;
                continue;
            }
            if (i % 25 == 0) {
                count += 2;
                continue;
            }
            if (i % 5 == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
