package Practice_0703;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            for (int i = 0; i < s.length(); i++) {
                char a = s.charAt(i);
                System.out.println(prove(a));
            }
        }

    }
    private static String prove(char a){
        byte b = (byte)a;
        String binaryString = Integer.toBinaryString(b);
        for (int i = 0; i < 8 - binaryString.length()-1; i++) {
            binaryString = "0" + binaryString;
        }
        int count = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if(binaryString.charAt(i) == '1'){
                count ++;
            }
        }
        if(count%2==1){
            binaryString = "0"+binaryString;
        }else{
            binaryString = "1"+binaryString;

        }
        return binaryString;
    }
}
