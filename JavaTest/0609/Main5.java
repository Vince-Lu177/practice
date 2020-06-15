package Practice_0609;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = String.valueOf(n);
        StringBuilder  stringBuilder = new StringBuilder(s);
        System.out.println(stringBuilder.reverse().toString());
    }
}
