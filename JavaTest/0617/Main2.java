package Practice_0617;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        System.out.println(getNum2((32*1000000007 + 1)/30000000));
        System.out.println((32*1000000007 + 1)/30000000);
        System.out.println((long)(32*1000000007L + 1));
    }

    private static boolean getNum1(double num) {
        while (num >= 1.0) {
            if (num == 1.0) {
                return true;
            } else {
                num /= 2.0;
            }
        }
        return false;
    }

    private static int getNum2(int num) {
        int count = 0;
        while (num >= 1) {
            if (num == 1) {
                return count;
            } else {
                num /= 2;
                count++;
            }
        }
        return -1;
    }
}
