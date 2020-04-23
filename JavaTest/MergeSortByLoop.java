package practice.practice.JavaTest;

import java.util.Arrays;

public class MergeSortByLoop {
    public static void mergeSortByLoop(int[] array) {
        //归并排序的非递归实现--通过分组实现
        //引入gap变量进行分组
        //当gap为1的时候,[0,1)和[1,2)进行合并,[2,3)和[3,4)进行合并
        //当gap为2的时候,[0,2)和[2,4)进行合并,[4,6)和[6,8)进行合并
        //当gap为4的时候,[0,4)和[4,8)进行合并
        for (int gap = 1; gap < array.length; gap *= 2) {
            //进行具体分组
            for (int i = 0; i < array.length; i += gap * 2 ) {
                //当前相邻组[beg,mid),[mid,end)
                //循环了一次,就完成了相邻组之间的合并
                int beg = i;
                int mid = i + gap;
                int end = i + 2 * gap;
                if(mid >= array.length){
                    mid = array.length;
                }
                if(end > array.length){
                    end = array.length;
                }
                merge(array,beg,mid,end);
            }
        }
    }

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

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        mergeSortByLoop(array);
        System.out.println(Arrays.toString(array));
    }
}
