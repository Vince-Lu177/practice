package Practice_0716;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            String toRemove = c + "";
            s1 = s1.replaceAll(toRemove,"");
        }
        System.out.println(s1);
    }
}
