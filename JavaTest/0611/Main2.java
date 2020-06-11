package Practice_0611;

import java.util.Arrays;

public class Main2 {
    public static int[] multiply(int[] A) {
        int[] B = new int[A.length];
        int a = 1;
        for (int i = 1; i < A.length; i++) {
            a *= A[i];
        }
        B[0] = a;
        a = 1;
        for (int i = 0; i < A.length - 1; i++) {
            a *= A[i];
        }
        B[B.length - 1] = a;
        for (int i = 1; i < A.length - 1; i++) {
            int k = 1;
            for (int j = 0; j < A.length; j++) {


                if(j == i){
                   continue;
                }
                k *= A[j];
            }
            B[i] = k;
        }

        return B;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int[] arr2 = multiply(arr);
        System.out.println(Arrays.toString(arr2));
    }
}
