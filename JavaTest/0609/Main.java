package Practice_0609;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n < 1 || n > 1000) {
            System.out.println(-1);
        }
        long sum = 1L;
        for (int i = n; i > 1; i--) {
            sum *= i;
        }
        System.out.println(sum);
        int count = 0;
        while(sum > 0){
            if(sum % 10 != 0){
                break;
            }else{
                count++;
                sum /= 10;
            }
        }
        System.out.println(count);
    }
}
