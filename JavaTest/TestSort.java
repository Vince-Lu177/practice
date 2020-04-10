package practice.practice.JavaTest;


public class TestSort {
    //插入排序：和顺序表插入十分相似
    //[0,bound) 已排序区间
    //[bound,size) 待排序区间
    //先获取bound位置的元素，往已排序区间插入，插入完毕后已排序任然是有序的
    //吧bound位置的元素在前面找个合适的位置，同时需要搬运附近相关元素
    public static void insertSort (int[] array){
        //通过bound来划分区间
        for (int bound = 1; bound < array.length; bound++) {
            int v = array[bound];
            int cur = bound - 1;//已排序区间的最后一个下标
            for(;cur >= 0;cur--){
                //此处写成array[cur] >= v就不是稳定排序了
                if(array[cur] > v){
                    array[cur + 1] = array[cur];
                }else{
                    //此时不需要搬运
                    break;
                }
            }
            array[cur + 1] = v;
        }
    }

    //希尔排序：进阶版本的插入排序，先分组，然后针对每个组进行插入排序
    //逐渐缩小组gap的个数，最终的整个数组就接近有序了
    public static void shellSort(int[] array){
         int gap = array.length / 2;
         while(gap > 1){
             //需要循环进行排插
             insertSortGap(array,gap);
             gap = gap / 2;
         }
         insertSortGap(array,1);
    }

    private static void insertSortGap(int[] array, int gap) {
        for(int bound = gap;bound < array.length;bound++){
            int v = array[bound];
            int cur = bound - gap;
            for(;cur >= 0;cur -= gap){
                if(array[cur] > v){
                    array[cur + gap] = array[cur];
                }else{
                    break;
                }
            }
            array[cur + gap] = v;
        }
    }

    //选择排序：基于打擂台的思想，每次从组中找到最小值，然后把最小值放到合适的位置
    //[0,bound)已排序区间
    //[bound，size)待排序区间
    //按照打擂台的方式，从待排序区间找一个最小值放到不bound位置上
    public static void selectSort(int[] array){
        for (int bound = 0; bound < array.length; bound++) {
            //以bound位置作为擂主，循环从待排序区间中取出元素和bound位置元素比较
            //如果打擂成功就进行交换
            for (int cur = bound + 1; cur < array.length; cur++) {
                if(array[cur] < array[bound]){
                    int tmp = array[cur];
                    array[cur] = array[bound];
                    array[bound] = array[cur];
                }
            }
        }
    }

    //堆排序
    //把数建成一个大堆，把堆顶元素和最后一个元素进行交换，把最后一个元素删除，再从堆顶向下调整即可
    public static void heapSort(int[] array){
        //先建立小堆
        createHeap(array);
        //循环地把堆顶元素交换到最后，并调整堆
        //循环次数length - 1，只剩最后一个元素有序
        for (int i = 0; i < array.length; i++) {
            //交换堆顶元素和最后一个元素
            //堆的元素array.length - 1
            swap(array,0,array.length - i -1);
            //最后一个元素的下标array.length - i - 1
            //[0,array.length - i -1)待排序区间
            //[array.length - i - 1,size)
            shiftDown(array,array.length - i - 1,0);
        }
    }

    private static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while(child < size){
            if(child + 1 < size && array[child + 1] > array[child]){
                child = child + 1;
            }
            if(array[parent] < array[child]){
                swap(array,parent,child);
            }else{
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    private static void createHeap(int[] array) {
        for (int i = (array.length - 1 - 1) / 2; i >= 0 ; i--) {
            shiftDown(array,array.length,i);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    //冒泡排序
    //核心和堆排序很相似，每次找到最大或者最小值放在合适的位置
    //[0,bound) 待排序区间
    //[bound,size)已排序区间
    //从前往后遍历，找最大值
    //从后往前遍历，找最小值
    public static void bubbleSort(int[] array){
        for(int bound = 0;bound < array.length;bound++){
            for(int cur = array.length - 1;cur > bound;cur--){
                if(array[cur - 1] > array[cur]){
                    swap(array,cur - 1,cur);
                }
            }
        }
    }
}
