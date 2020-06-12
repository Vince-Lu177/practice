package Practice_0610;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if(num < 1 || num > 1000000){
            System.out.println(-1);
        }
        int res = getSteps(num);
        System.out.println(res);
    }

    private static int getSteps(int num) {
        if(num <= 3){
            return 0;
        }
        if(num == 4){
            return 1;
        }

        for (int i = 2; i < num; i++) {
            int n1 = Fib(i);
            int n2 = Fib(i - 1);
            if(n1 == num || n2 == num){
                return 0;
            }
            if(num < n1 && num > n2){
                return Math.min((num - n2),(n1 - num));
            }
        }
        return - 1;
    }

    private static int Fib(int n){
        if(n == 0){
            return 0;
        }
        int last1 = 1;
        int last2 = 1;
        int cur = 1;
        for (int i = 2; i < n; i++) {
            cur = last1 + last2;
            last2 = last1;
            last1 = cur;
        }
        return cur;
    }
}
