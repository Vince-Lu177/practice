package Practice_0715;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            for (int i = 0; i < 26; i++) {
                char c = (char) ('a' + i);
                String insert = c + "";
                if(helper(s)){
                    System.out.println("YES");
                    return;
                }
                for (int j = 0; j < s.length(); j++) {
                    if(helper(insert + s) || helper(s+insert)){
                        System.out.println("YES");
                        return;
                    }
                    String mid = s.substring(0,j)+insert+s.substring(j,s.length());
                    if(helper(mid)){
                        System.out.println("YES");
                        return;
                    }
                }
            }
            System.out.println("NO");
        }

    }
    private static boolean helper(String s){
        StringBuilder stringBuilder = new StringBuilder(s);
        return stringBuilder.reverse().toString().equals(s);
    }
}
