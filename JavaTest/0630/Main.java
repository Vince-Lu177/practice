package Practice_0630;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            String s3 = scanner.nextLine();
            String[] arr = s2.split(" ");
            for (int i = 0; i < arr.length; i++) {
                if(arr[i].equals(s3)){
                    System.out.println(i);
                    return;
                }
            }
            System.out.println(-1);
        }
    }
}
