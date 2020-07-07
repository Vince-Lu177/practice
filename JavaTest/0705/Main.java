package Practice_0705;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if(s == null){
            System.out.print("");
            return;
        }
        String[] arr = s.split(" ");
        System.out.print(arr[arr.length - 1]);
        for(int i = arr.length - 2;i>=0;i--){
            System.out.print(" " + arr[i]);
        }
    }
}