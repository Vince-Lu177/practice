package Practice_0626;


import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] strings = s.split(" ");
        int[] arr = new int[strings.length - 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strings[i + 1]);
        }
        int a1 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 10 == 0) {
                a1 += arr[i];
            }
        }
        String A1;
        if (a1 == 0) {
            A1 = "N";
        } else {
            A1 = a1 + "";
        }
        int a2 = 0;
        int flag = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 5 == 1) {
                a2 += (arr[i] * flag);
                flag = -flag;
            }
        }
        String A2;
        if (a2 == 0) {
            A2 = "N";
        } else {
            A2 = a2 + "";
        }
        int a3 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 5 == 2) {
                a3++;
            }
        }
        String A3;
        if (a3 == 0) {
            A3 = "N";
        } else {
            A3 = a3 + "";
        }
        int a4 = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 5 == 3) {
                a4 += arr[i];
                count++;
            }
        }
        String A4;
        if (a4 == 0) {
            A4 = "N";
        } else {
            DecimalFormat df = new DecimalFormat("#.#");
            A4 = Double.parseDouble(df.format(((double) a4 / count))) + "";
        }
        int a5 = 0;
        int com = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 5 == 4) {
                com = arr[i];
                if (com > a5) {
                    a5 = com;
                }
            }
        }
        String A5;
        if (a5 == 0) {
            A5 = "N";
        } else {
            A5 = a5 + "";
        }
        System.out.println(A1 + " " + A2 + " " + A3 + " " + A4 + " " + A5);
    }
}
