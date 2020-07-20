package Practice_0720;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arr = str.split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        if(n<=0||m<=0){
            System.out.println();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = n; j >= i; j--) {
                if(i + j == m){
                    System.out.println(i + " "+ j);
                }
            }
        }
        if(n >= m){
            System.out.println(m);
        }

    }
}
