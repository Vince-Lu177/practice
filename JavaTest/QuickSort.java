package practice.practice.JavaTest;

import java.util.Arrays;
import java.util.Stack;

public class QuickSort {
    //快速排序--递归
    //升序排序
    //1.从待排序区间找到一个基准值(常见的取2区间的第一个元素或者最后一个元素)
    //2.以基准值为中心把整个区间整理成三个部分，左侧区间都小于等于基准值，右侧区间都大于等于基准值
    //3.针对左右区间进行进一步的递归

    //一次整理的过程
    //1.取最右侧元素为基准值
    //2.从左往右找到一个大于基准值的元素(left)
    //3.从右往左找到一个小于基准值的元素(right)
    //4.交换left和right位置的元素
    //5.循环上述步骤，找到left和right重合
    //6.交换重合元素和基准值的位置

    public static void quickSort(int[] array){
        //辅助完成递归过程
        quickSortHelper(array,0,array.length - 1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if(left >= right){
            //区间只有0个元素或1个元素
            return;
        }
        //针对[left，right]进行整理
        int index = partition(array,left,right);
        quickSortHelper(array,left,index - 1);
        quickSortHelper(array,index + 1,right);
    }

    private static int partition(int[] array, int left, int right) {
        int beg = left;
        int end = right;
        //取最右侧元素为基准值
        int base = array[right];
        while(beg < end){
            while (beg < end && array[beg] <= base){
                //从左往右，找比基准值大的元素，<= base的元素就跳过
                beg++;
            }
            //当循环结束，beg 要么和 end 重合，要么 beg 就指向一个大于base的元素
            while(beg < end && array[end] >= base){
                //从右往左，找比基准值小的元素，>= base的元素都跳过
                end--;
            }
            //当循环结束，end 要么和 beg 重合，要么 end 就指向一个小于base的元素
            //交换 beg 和 end 的值
            swap(array,beg,end);
        }
        //当 beg 和 end 重合的时候，交换重合位置和基准值的位置
        swap(array,beg,right);
        return beg;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    //快速排序--非递归(借助栈来模拟递归过程)
    public static void quickSortByLoop(int[] array){
        Stack<Integer> stack = new Stack<>();
        //stack存放数组下标，通过下标来处理接下来要处理的区间
        //初始情况下，先把有边界入栈，再把左侧边界入栈，左右区间构成前闭后闭区间
        stack.push(array.length - 1);
        stack.push(0);
        while(!stack.isEmpty()){
            //取元素的顺序和插入元素的顺序相反
            int left = stack.pop();
            int right = stack.pop();
            if(left >= right){
                //区间只有1个或0个元素，不需要整理
                continue;
            }
            int index = partition(array,left,right);
            //通过partition方法把区间整理成以基准值为中心，左侧元素都小于等于基准值，右侧元素都大于等于基准值
            //[index + 1,right]基准值的右区间
            stack.push(right);
            stack.push(index + 1);
            //[left,index - 1]基准值的左区间
            stack.push(index - 1);
            stack.push(left);
        }
    }

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        //quickSort(array);
        quickSortByLoop(array);
        System.out.println(Arrays.toString(array));
    }
}
