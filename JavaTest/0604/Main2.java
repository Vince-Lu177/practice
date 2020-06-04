package Practice_0604;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        if(a == null){
            System.out.println(a);
            return;
        }
        if(b == null){
            System.out.println(a);
            return;
        }
        System.out.println(remove(a,b));
    }
    public static StringBuilder remove(String a,String b ){
        StringBuilder res = new StringBuilder(a);
        for (int i = 0; i < b.length(); i++) {
            char b1 = b.charAt(i);
            for (int j = 0; j < a.length(); j++) {
                char a1 = a.charAt(j);
                if(b1 == a1){
                   res.deleteCharAt(j);

                }
            }
        }
        return res;
    }
}
