package Practice_0630;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s1 = scanner.nextLine();
            if(s1.contains(".")){
                fun1(s1);
            }else {
                fun2(s1);
            }
        }
    }
    private static void fun1(String s1){
        String[] arr = s1.split("\\.");
        Integer change = 0;
        for (int i = 0; i < arr.length; i++) {
            change = Integer.parseInt(arr[i]);
            arr[i] = Integer.toBinaryString(change);
            int len = 8 - arr[i].length();
            StringBuilder zero = new StringBuilder();
            for (int j = 0; j < len; j++) {
                zero.append(0);
            }
            arr[i] = zero.toString() + arr[i];
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            stringBuilder.append(arr[i]);
        }
        System.out.println(Integer.valueOf(stringBuilder.toString(), 2));
    }
    private static void fun2(String s2){
        Integer a = Integer.parseInt(s2);
        String res = Integer.toBinaryString(a);
        StringBuilder stringBuilder1 = new StringBuilder();
        for (int i = 0; i < 32 - res.length(); i++) {
            stringBuilder1.append(0);
        }
        res = stringBuilder1.append(res).toString();
        String res1 = res.substring(0, 8);
        String res2 = res.substring(8, 16);
        String res3 = res.substring(16, 24);
        String res4 = res.substring(24, 32);
        String stringBuilder2 = Integer.valueOf(res1, 2) + "." +
                Integer.valueOf(res2, 2) + "." +
                Integer.valueOf(res3, 2) + "." +
                Integer.valueOf(res4, 2);
        System.out.println(stringBuilder2);
    }
}


/*

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        String[] arr = s1.split("\\.");
        Integer change = 0;
        for (int i = 0; i < arr.length; i++) {
            change = Integer.parseInt(arr[i]);
            arr[i] = Integer.toBinaryString(change);
            int len = 8-arr[i].length();
            StringBuilder zero = new StringBuilder();
            for (int j = 0; j < len; j++) {
                zero.append(0);
            }
            arr[i] = zero.toString() + arr[i];
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            stringBuilder.append(arr[i]);
        }
        System.out.println(Integer.valueOf(stringBuilder.toString(),2));
        Integer a = Integer.parseInt(s2);
        String res = Integer.toBinaryString(a);
        StringBuilder stringBuilder1 = new StringBuilder();
        for (int i = 0; i < 32 - res.length(); i++) {
            stringBuilder1.append(0);
        }
        res = stringBuilder1.append(res).toString();
        String res1 = res.substring(0,8);
        String res2 = res.substring(8,16);
        String res3 = res.substring(16,24);
        String res4 = res.substring(24,32);
        String stringBuilder2 = Integer.valueOf(res1, 2) + "." +
                Integer.valueOf(res2, 2) + "." +
                Integer.valueOf(res3, 2) + "." +
                Integer.valueOf(res4, 2);
        System.out.println(stringBuilder2);
    }
    }
}

 */