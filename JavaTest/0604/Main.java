package Practice_0604;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n < 1 || n > 100){
            System.out.println(-1);
            return;
        }
        int m = n / 8;
        int x = n % 8;
        if(x % 2 != 0){
            System.out.println(-1);
            return;
        }
        if(x == 0){
            System.out.println(m);
            return;
        }
        if(m == 0 && x == 6){
            System.out.println(1);
            return;
        }
        if(m == 0 && x != 6){
            System.out.println(-1);
            return;
        }
        System.out.println(m + 1);
    }
}
