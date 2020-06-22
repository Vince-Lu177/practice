package Practice_0622;

import java.util.Arrays;

public class Main2 {
    public static boolean[] chkSubStr(String[] p, int n, String s) {
        // write code here
        boolean[] res = new boolean[n];
        for (int i = 0; i < n; i++) {
            res[i] = s.contains(p[i]);
        }
        return res;
    }
    private static void bubbleSort1(int[] arr){
        for (int bound = 0; bound < arr.length; bound++) {
            for(int cur = arr.length-1;cur>bound;cur--){
                if(arr[cur-1]>arr[cur]){
                    int tmp = arr[cur];
                    arr[cur] = arr[cur-1];
                    arr[cur-1] = tmp;
                }
            }
        }
    }
    public static void main(String[] args) {
//        String[] p = {"a","b","c","d"};
//        System.out.println(Arrays.toString(chkSubStr(p,4,"abc")));
        int[] arr= {1,5,9,3,4,7};
 //       System.out.println(Integer.parseInt("12"));
        bubbleSort1(arr);
        System.out.println(Arrays.toString(arr));
    }
}
