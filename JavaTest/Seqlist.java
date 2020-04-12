package practice.practice.JavaTest;

public class Seqlist {
    private int[] datas = null;
    private int size = 0;
    private boolean ture;

    //使用构造方法初始化
    //实现顺序表要new出一个一定长度的数组，此时顺序表里的元素可以认为是没有的(空顺序表)，
    //通过add方法往顺序表中新增元素，这才是有效元素。
    public Seqlist(){
        datas = new int[100];
    }
    public int getSize(){
        return size;
    }
    //打印顺序表
    public void display(){
        //依次打印出每个元素
        String result = "[";
        for (int i = 0; i < size ; i++) {
            result += i;
            if(i < size - 1){
                result += ",";
            }
        }
        result += "]";
        System.out.println(result);
    }

    //在pos位置新增元素
    //pos表示新增元素的位置，data表示新增的值
    public void add(int pos,int data){
    //判定pos是否为有效的值
    if(pos < 0 || pos > size){
        return;
    }
    //扩容
//    if(size >= datas.length){
//        int[] newdatas = new int[2 * datas.length];
//        for (int i = 0; i < datas.length; i++) {
//            newdatas[i] = datas[i];
//        }
//        datas = newdatas;
//    }
    //尾插的情况(比较简单)，直接放在size的位置
    if(pos == size){
        datas[pos] = data;
        size++;
        return;
    }
    //普通位置的插入，从后往前
        for (int i = size - 1; i >= pos; i--) {
            datas[i + 1] = datas[i];
        }
        datas[pos] = data;
        size++;
    }

    //判定是否包含某个元素
    public boolean contains(int toFind){
        for (int i = 0; i < size; i++) {
            if(datas[i] == toFind){
                return ture;
            }
        }
        return false;
    }

    //查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < size; i++) {
            if (datas[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    //获取pos位置的元素
    public int getPos(int pos) throws Exception {
        if(pos < 0 || pos > size){
            throw new Exception("下标越界");
        }
        return datas[pos];
    }

    //给pos位置的元素设置成value
    public void setPos(int pos,int value) throws Exception {
        if(pos < 0 || pos > size){
            throw new Exception("下标越界");
        }
        datas[pos] = value;
    }

    //删除第一次出现的关键字key
    public void remove(int toRemove){
    //toRemove是要被删除的元素
    //1.先找到toRemove对应下标
    //2.如果下标是最后一个元素，直接尾删即可
    //3.如果下标是中间元素，需要先搬运，再删除
    //4.删除完毕之后，size--
    int pos = search(toRemove);
    if(pos == -1){
        return;
    }
    //尾删
    if(pos == size){
            size--;
        }
        for (int i = pos; i < size - 1; i++) {
            datas[i] = datas[i + 1];
        }
        size--;
    }

    //清空顺序表
    public void clear(){
        size = 0;
    }
}
