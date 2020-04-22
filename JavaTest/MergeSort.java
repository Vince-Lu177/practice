package practice.practice.JavaTest;

import java.util.Arrays;

public class MergeSort {
    public static void merge(int[] array,int low,int mid,int high){
        //把有序区间[low,mid),[mid,high)合并成一个有序区间
        int[] output = new int[high - low];
        int outputIndex = 0;
        //记录output数组中元素存放个数
        int cur1 = low;
        int cur2 = mid;
        while(cur1 < mid && cur2 < high){
            if(array[cur1] <= array[cur2]){
                //此处写成<=保证稳定性
                output[outputIndex] = array[cur1];
                outputIndex++;
                cur1++;
            }else{
                output[outputIndex] = array[cur2];
                outputIndex++;
                cur2++;
            }
        }
        //当循环结束,cur1或者cur2肯定有一个到达了末尾,此时另一个还剩下一些内容
        while(cur1 < mid){
            output[outputIndex] = array[cur1];
            outputIndex++;
            cur1++;
        }
        while(cur2 < high){
            output[outputIndex] = array[cur2];
            outputIndex++;
            cur2++;
        }
        //把output数组中的内容搬回到原来的数组中
        for (int i = 0; i < high - low; i++) {
            array[low + i] = output[i];
        }
    }

    public static void mergeSort(int[] array){
        mergeSortHelper(array,0,array.length);
    }

    private static void mergeSortHelper(int[] array, int low, int high) {
        if(high - low <= 1){
            //数组中只有1个或0个元素
            return;
        }
        int mid = (low + high) / 2;
        mergeSortHelper(array,low,mid);
        //方法执行完[low,mid)就是一个有序区间
        mergeSortHelper(array,mid,high);
        //方法执行完[mid,high)就是一个有序区间
        //接下来对两个有序区间进行合并
        merge(array,low,mid,high);
    }

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
