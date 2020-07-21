package Practice_0721;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String str = scanner.nextLine();

            String[] arr = str.split("_");
            System.out.print(arr[0]);
            for (int i = 1; i < arr.length; i++) {
                System.out.print(arr[i].substring(0,1).toUpperCase()+arr[i].substring(1));
            }
            System.out.println();
        }

    }
}
