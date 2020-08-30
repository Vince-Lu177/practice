package exam_0830;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        if(s1 == null){
            System.out.println();
            return;
        }
        if(s2 == null){
            System.out.println(s1);
        }
        String[] strings = s1.split("");
        StringBuilder  stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            if(!s2.contains(strings[i])){
                stringBuilder.append(strings[i]);
            }
        }
        System.out.println(stringBuilder);
    }
}
