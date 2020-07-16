package Practice_0716;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] arr = s.split(" ");
        System.out.print(arr[arr.length - 1]);
        for (int i = arr.length-2; i >= 0; i--) {
            System.out.print(" "+arr[i]);
        }
    }
}
