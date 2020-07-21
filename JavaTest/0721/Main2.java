package Practice_0721;

import java.util.Scanner;
public class Main2{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if(str == " "||str == null){
            System.out.print("");
            return;
        }
        String[] arr = str.split(" ");
        if(isWord(arr[arr.length - 1])) {
            System.out.print(arr[arr.length - 1]);
        }
        for(int i = arr.length - 2;i >= 0;i--){
            if(isWord(arr[i])) {
                System.out.print(" " + arr[i]);
            }
        }
    }
    private static boolean isWord(String s){
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c<'a'||c>'z'){
                return false;
            }
        }
        return true;
    }
}
