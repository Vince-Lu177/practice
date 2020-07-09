package Practice_0707;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        String[] arr = new String[Integer.parseInt(num)];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextLine();
        }
        for (String s : arr) {
            Integer value = map.get(s);
            if (value == null) {
                map.put(s, 1);
            } else {
                map.put(s, value + 1);
            }
        }
        Integer a1 = map.get("C J");
        if (a1 == null) {
            a1 = 0;
        }
        Integer a2 = map.get("J B");
        if (a2 == null) {
            a2 = 0;
        }
        Integer a3 = map.get("B C");
        if (a3 == null) {
            a3 = 0;
        }
        Integer a4 = map.get("J C");
        if (a4 == null) {
            a4 = 0;
        }
        Integer a5 = map.get("B J");
        if (a5 == null) {
            a5 = 0;
        }
        Integer a6 = map.get("C B");
        if (a6 == null) {
            a6 = 0;
        }
        int win = a1 + a2 + a3;
        int lose = a4 + a5 + a6;
        int allWin = Integer.parseInt(num) - win - lose;
        System.out.println(win + " " + allWin + " " + lose);
        System.out.println(lose + " " + allWin + " " + win);
        int res1 = Math.max(a1, a2);
        int res2 = Math.max(res1, a3);
        while (true) {
            if (res2 == a3) {
                System.out.print("B" + " ");
                break;
            }
            if (res2 == a1) {
                System.out.print("C" + " ");
                break;
            }
            if (res2 == a2) {
                System.out.print("J" + " ");
                break;
            }
        }
        int res3 = Math.max(a4, a5);
        int res4 = Math.max(res3, a6);
        while (true) {
            if (res4 == a5) {
                System.out.print("J");
                break;
            }
            if (res4 == a6) {
                System.out.print("B");
                break;
            }
            if (res4 == a4) {
                System.out.print("C");
                break;
            }
        }
    }

}
