package Practice_0708;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String str = scanner.nextLine();
            String[] arr = str.split(" ");
            double R_2 = Math.pow(Double.parseDouble(arr[3])-Double.parseDouble(arr[0]),2)+
                    Math.pow(Double.parseDouble(arr[4])-Double.parseDouble(arr[1]),2)+
                    Math.pow(Double.parseDouble(arr[5])-Double.parseDouble(arr[2]),2);
            double R = Math.sqrt(R_2);
            double S = (4.0/3.0)*R*R*R*Math.acos(-1);
            System.out.printf("%.3f",R);
            System.out.print(" ");
            System.out.printf("%.3f",S);
        }
    }
}
