package Practice_0531;

import java.util.Arrays;

public class Main {
    public static int find(String a, String b) {
        int res = 0;
        if (a == null && b == null) {
            return 0;
        }
        if (a == null && b != null) {
            if (isPalindrome(b)) {
                return 1;
            } else {
                return 0;
            }
        }
        for (int i = 0; i < a.length(); i++) {
            String c = a.substring(0, i) + b + a.substring(i, a.length());
            if (isPalindrome(c)) {
                res++;
            }
        }
        return res;
    }

    private static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        String x = new StringBuilder(s).reverse().toString();
        return x.equals(s);
    }

    public static int findKth(int[] a, int n, int K) {
        sort(a, n);
        return a[K];
    }
        public static void sort(int[] a,int n){
            for (int i = 0; i < n; i++) {
                for (int j = n - 1; j > i; j--) {
                    if (a[j - 1] < a[j]) {
                        int tmp = a[j - 1];
                        a[j - 1] = a[j];
                        a[j] = tmp;
                    }
                }
            }
        }


}
