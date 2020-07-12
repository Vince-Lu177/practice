package Practice_0710;

import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            s=s.replace("0x","");
            System.out.println(Long.parseLong(s,16));
        }
    }
}
