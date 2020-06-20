package Practice_0620;


import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int length = scanner.nextInt();
        if (s.length() <= length) {
            System.out.println(s);
            return;
        }
        int max = 0;
        for (int i = 0; i < s.length() - length; i++) {
            String part = s.substring(i, i + length);
            int count = 0;
            for (int j = 0; j < part.length(); j++) {
                char c = part.charAt(j);
                if (c == 'G' || c == 'C') {
                    count++;
                }
            }
            if (max < count) {
                max = count;
            }
        }
        for (int i = 0; i < s.length() - length; i++) {
            String part = s.substring(i, i + length);
            int count = 0;
            for (int j = 0; j < part.length(); j++) {
                char c = part.charAt(j);
                if (c == 'G' || c == 'C') {
                    count++;
                }
            }
            if (max == count) {
                System.out.println(part);
                return;
            }
        }
    }
}
