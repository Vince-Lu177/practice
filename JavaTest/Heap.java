package practice.practice.JavaTest;

public class Heap {
    //堆的向下调整(以小堆为例)
    //1.先设定根节点为当前节点(通过下标来获取)，比较左右子树的值，找出更小的值，用child来标记
    //2.比较child和parent的值，如果child比parent小，则不满足小堆的规则，需要进行交换
    //3.如果child比parent大，满足小堆的规则，不需要交换，调整就结束了
    //4.处理完一个节点之后，从当前的child出发，循环之前的过程
    public static void shiftDown(int[] array,int size,int index){
        //通过size指定array中哪些元素是有效的元素
        //index表示从哪个位置的下标开始调整
        //左右子树都是堆，才能调整
        int parent = index;
        int child = 2 * parent + 1;
        //根据parent的下标找到左子树的下标
        while(child < size){
            //1.比较左右子树，找到较小值
            if(child + 1 < size && array[child + 1] < array[child]){
                //child + 1表示右子树的下标
                child  = child + 1;
                //child时刻保存较小值的下标
            }
            //通过上面的比较，还不知道child是左子树还是右子树，但知道child下标一定对应左右子树最小值的下标
            if(array[child] < array[parent]){
                //不符合小堆规则，交换父子节点
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            }else{
                //调整完毕
                break;
            }
            //更新parent和child，处理下一个数据
            parent = child;
            child = 2 * parent + 1;
        }
    }
    public static void createHeap(int[] array,int size){
        for (int i = (size - 1 - 1) / 2 ;i >= 0;i--) {
            //size - 1得到的是最后一个叶子结点，再- 1 除以2就得到了最后一个叶子结点的父节点(倒数第一个非叶子节点)
            shiftDown(array,size,i);
        }
    }
}
