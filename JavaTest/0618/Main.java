package Practice_0618;

import java.util.Scanner;
//4 3 1 1 2 3 4 5 6 3 2 1 2 3 4 5 6 2 2 1 1 1 1 3 2 1 2 3 4 5 6
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        str +=" 10";
        String[] arr = str.split(" ");
        String h = arr[0];
        int count = 0;
        arr = deleteArr(0,arr);
        while (true) {
            StringBuilder res = new StringBuilder("");
            int beg = Integer.parseInt(arr[0]);
            int wash = Integer.parseInt(arr[1]);
            String[] arr2 = subArray(0, (beg + 1) * 2, arr);
            String[] arr1 = deleteArr(1, arr2);
            String[] result = sort(arr1).toString().split(" ");
            for (int i = 1; i < wash-1; i++) {
                result = sort(result).toString().split(" ");
            }

            //实现打印
            for (int i = 0; i < result.length; i++) {
                res.append(result[i] + " ");
            }
            if(count != Integer.parseInt(h) - 1){
                System.out.print(res.toString());
            }
//            if(count == Integer.parseInt(h)){
//                for (int i = 0; i < result.length; i++) {
//                    res.append(result[i]);
//                }
//                String s = res.toString();
//                System.out.print(s.substring(0,s.length() - 1));
//            }
            count++;
            if(count == Integer.parseInt(h)){
                break;
            }
            arr = deleteArr((beg + 1) * 2 -1,arr);
        }
//        String[] arr = {"1","2","3","4","5","6"};
//        String[] res = sort(arr);
//        StringBuilder sb = new StringBuilder("");
//        for (int i = 0; i < res.length; i++) {
//            sb.append(res[i]);
//        }
//        System.out.println(sb.toString());
//        StringBuilder sb = new StringBuilder("");
//        for (int i = 0; i < arr.length; i++) {
//            sb.append(arr[i]);
//        }
//        System.out.println(sb.toString());
        StringBuilder res = new StringBuilder("");
        int beg = Integer.parseInt(arr[0]);
        int wash = Integer.parseInt(arr[1]);
        String[] arr2 = subArray(0, (beg + 1) * 2, arr);
        String[] arr1 = deleteArr(1, arr2);
        String[] result = sort(arr1).toString().split(" ");
        for (int i = 1; i < wash-1; i++) {
            result = sort(result).toString().split(" ");
        }

        //实现打印
        for (int i = 0; i < result.length; i++) {
            res.append(result[i] + " ");
        }
        String s = res.toString();
        System.out.print(s.substring(0,s.length()-1));
    }
        private static String[] subArray(int head, int tail, String[] arr){
            String[] res = new String[tail-head + 1];
            for (int i = 0; i < res.length; i++) {
                res[i] = arr[head];
                head++;
            }
            return res;
        }
        private static String[] deleteArr(int tail, String[] arr){
            String[] newArray = new String[arr.length - tail - 1];
            for (int i = 0; i < newArray.length; i++) {
                newArray[i] = arr[++tail];
            }
            return newArray;
        }
        private static StringBuilder sort (String[] arr1){
            int mid = arr1.length/2-1;
            String[] s1 = subArray(0,mid,arr1);
            String[] s2 = subArray(mid+1,arr1.length-1,arr1);
            StringBuilder stringBuilder = new StringBuilder("");
            for (int i = 0; i < s1.length; i++) {
                stringBuilder.append(s1[i] + " ");
                stringBuilder.append(s2[i] + " ");
            }
            return stringBuilder;
        }
    }

