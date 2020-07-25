package Practice_0725;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static int findMaxGap(int[] A, int n) {
        // write code here
        int[] maxList = new int[n];
        for (int i = 0; i <= n - 2; i++) {
            int[] left = new int[i+1];
            int[] right = new int[n-1-i];
            for (int j = 0; j < i+1; j++) {
                left[j] = A[j];
            }
            if(i == n - 2){
                right[0] = A[n-1];
            }else{
                for (int k = 0; k < n-1-i; k++) {
                    right[k] = A[k+1];
                }

            }

            System.out.println(Arrays.toString(left));
            System.out.println(Arrays.toString(right));
            int maxLeft = maxArray(left);
            int maxRight = maxArray(right);
            //int max = maxLeft>=maxRight?maxLeft-maxRight:maxRight-maxLeft;
            int max = Math.abs(maxLeft-maxRight);
            maxList[i] = max;
        }

        return maxArray(maxList);
    }
    private static int maxArray(int[] arr){
        Arrays.sort(arr);
        return arr[arr.length-1];
    }

    public static void main(String[] args) {
        int[] arr = {0,0};
        System.out.println(findMaxGap(arr,2));
    }
}
