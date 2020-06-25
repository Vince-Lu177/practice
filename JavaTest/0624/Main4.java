package Practice_0624;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue queue = new LinkedList();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            queue.add(s);
            System.out.println(String.valueOf(queue.peek()));
        }
        while(!queue.isEmpty()){
            String str = String.valueOf(queue.peek());
            char[] chars = str.toCharArray();
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
