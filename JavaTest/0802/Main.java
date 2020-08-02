package Practice_0802;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if(k > input.length || k <=0 || input.length <= 0){
            return null;
        }
        ArrayList result = new ArrayList();
        Set set = new HashSet();
        for (int i = 0; i < input.length; i++) {
            set.add(input[i]);
        }
        Object[] arr = set.toArray();
        int[] arr2 = new  int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = (int) arr[i];
        }
        bubbleSort(input);
        for (int i = 0; i < k; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1,5,3,9,3,6,9};
        System.out.println(GetLeastNumbers_Solution(a, 5));
        //bubbleSort(a);
        //System.out.println(Arrays.toString(a));
    }

    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for(int j = arr.length - 1;j > i;j--){
                if(arr[j - 1] > arr[j]){
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}
