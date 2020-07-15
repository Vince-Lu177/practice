package Practice_0715;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            int res = helper2(s);
            if (res == 1) {
                System.out.println("YES");
            }
            if (res == 0) {
                System.out.println("NO");
            }
        }
    }

    private static int helper2(String s) {
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            String insert = c + "";
            if (helper(s)) {

                return 1;
            }
            for (int j = 0; j < s.length(); j++) {
                if (helper(insert + s) || helper(s + insert)) {

                    return 1;
                }
                String mid = s.substring(0, j) + insert + s.substring(j, s.length());
                if (helper(mid)) {

                    return 1;
                }
            }
        }
        return 0;
    }

    private static boolean helper(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        return stringBuilder.reverse().toString().equals(s);
    }
}
