package Practice_0622;

import java.util.Scanner;
//4
//0
//fang 90
//yang 50
//ning 70
//li 80

//3
//0
//fang 90
//yang 50
//ning 70
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.next();
        String type = scanner.next();
        int num = Integer.parseInt(n)+1;
        String[] arr = new String[num];
        for (int i = 0; i < num; i++) {
            arr[i] = scanner.nextLine();
            System.out.println(arr[i]);
        }
        int[] arr2 = new int[num];
        for (int i = 0; i < num; i++) {
            String[] a = arr[i].split(" ");
            arr2[i] = Integer.parseInt(a[a.length-1]);
        }
        if (type.equals("0")) {
            bubbleSort2(arr2);
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) {
                    if (arr[i].contains(arr2[j] + "")) {
                        System.out.println(arr[i]);
                        break;
                    }
                }
            }
        } else {
            bubbleSort1(arr2);
            for (int i = num - 1; i >= 0; i--) {
                for (int j = 0; j < num; j++) {
                    if (arr[i].contains(arr2[j] + "")) {
                        System.out.println(arr[i]);
                        break;
                    }
                }
            }
        }
    }

    //升序
    private static void bubbleSort1(int[] arr) {
        for (int bound = 0; bound < arr.length; bound++) {
            for (int cur = arr.length - 1; cur > bound; cur--) {
                if (arr[cur - 1] > arr[cur]) {
                    int tmp = arr[cur];
                    arr[cur] = arr[cur - 1];
                    arr[cur - 1] = tmp;
                }
            }
        }
    }

    //降序
    private static void bubbleSort2(int[] arr) {
        for (int bound = 0; bound < arr.length; bound++) {
            for (int cur = arr.length - 1; cur > bound; cur--) {
                if (arr[cur - 1] < arr[cur]) {
                    int tmp = arr[cur];
                    arr[cur] = arr[cur - 1];
                    arr[cur - 1] = tmp;
                }
            }
        }
    }

}
