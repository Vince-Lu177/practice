package Practice_0625;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sail = scanner.nextLine();
        String buy = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < buy.length(); i++) {
            if (!sail.contains(String.valueOf(buy.charAt(i)))) {
                count++;
            }else{
                StringBuilder stringBuilder = new StringBuilder(sail);
                int value =  stringBuilder.indexOf(String.valueOf(buy.charAt(i)));
                stringBuilder.deleteCharAt(value);
                sail = stringBuilder.toString();
            }
        }
        if (count != 0) {
            System.out.println("No " + count);
        } else {
            System.out.println("Yes " + (sail.length() - buy.length()));
        }
    }
}
