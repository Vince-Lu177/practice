package Practice_0624;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            char[] chars = s.toCharArray();
            char[] newChars = new char[chars.length];
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == ' ') {
                    newChars[i] = ' ';
                } else if (chars[i] <= 'E') {
                    chars[i] += 26;
                } else {
                    newChars[i] = (char) (chars[i] - 5);
                }
            }
            System.out.println(new String(newChars));
        }

    }
}
