package Practice_0722;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String str = scanner.nextLine();
            boolean flag = true;
            String[] arr = str.split(" ");
            for (int i = 0; i < arr[1].length(); i++) {
                char c = arr[1].charAt(i);
                if(arr[0].contains(c+"")) {
                    arr[0] = arr[0].replaceFirst(c+"","");
                }else{
                    flag = false;
                    break;
                }
            }

            if(flag){
                System.out.print("Yes");
            }else {
                System.out.print("No");
            }
        }
    }
}
