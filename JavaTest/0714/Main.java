package Practice_0714;

import java.util.Scanner;

public class Main {
    public String replaceSpace(String iniString, int length) {
        // write code here
        return iniString.replaceAll(" ", "%20");

    }

    private static int res = 0;

    public static int getLCA(int a, int b) {
        // write code here
        helper(1, a, b);
        return res;
    }

    private static boolean helper(int i, int a, int b) {
        int left = helper(2 * i, a, b) ? 1 : 0;
        int right = helper(2 * i + 1, a, b) ? 1 : 0;
        int mid = (i == a || i == b) ? 1 : 0;
        if (left + right + mid == 2) {
            res = i;
        }
        return left + right + mid > 0;
    }
//165 275 350 336 198 250 450 385 150 350 385 330 480 100 310 250 260 165 165 198 450 275 490 250 350 300 150 350 300 150 350 168 228 165 165 319 385 150 385 450 300 286 450 460 110 350 240 253 385 110 209 385 230 300 150 230 300 150 350 300 250 250 250 250 290 385 500 165 150 250 170 140 170 450 350 380 220
    public static void main(String[] args) {
        //System.out.println(getLCA(2,3));
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] arr = s.split(" ");
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res+=Integer.parseInt(arr[i]);
        }
        System.out.println(res/7700.0);
    }
}
