package Practice_0721;

import java.util.Scanner;
public class Main3{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arr = str.split(" ");
        System.out.print(arr[arr.length - 1]);
        for(int i = arr.length - 2;i >= 0;i--){
            System.out.print(" "+arr[i]);
        }
    }
}
