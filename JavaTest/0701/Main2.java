package Praztice_0701;


import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            if (test(num)) {
                System.out.println("YES!");
            }
            if (!test(num)) {
                System.out.println("NO!");
            }
        }
   }

    private static boolean test(int i) {
        int squ = i * i;
        String s = String.valueOf(squ);
        String s1 = String.valueOf(i);
        String s2 = s.substring(s.length() - s1.length());
        return s1.equals(s2);
    }
}
