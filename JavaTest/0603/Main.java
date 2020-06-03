package Practice_0603;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        Stack<Integer> stack = new Stack<>();
        while(true) {
            int a = getIndex(s);
            int m = 0;
            stack.push(a);


        }
    }
    public static int getIndex(String s){
        int i = 0;
        int m = 0;
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c < 'z' && c > 'a'){
                m = i;
                break;
            }
        }
        return m;
    }
}
