package practice.practice.JavaTest;

public class MyHashmap {
    static class Node{
        public int key;
        public int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] array = new Node[101];
    //array就是Hash表的本体,数组中的每个元素是链表的头结点
    private int size = 0;
    //Hash表的元素个数
    private static final double LOAD_FACTOR = 0.75;

    public void put(int key,int value){
        //如果key已经存在,就修改value的值
        //如果key不存在,就插入新的键值对
        //1.需要把key映射成数组下标
        int index = hashFunc(key);
        //2.根据下标找到相应的链表
        Node list = array[index];
        //3.判断key在链表中是否存在
        for(Node cur = list;cur != null;cur = cur.next){
            if(cur.key == key){
                cur.value = value;
                return;
            }
        }
        //4.循环结束,没有找到key的节点,直接插入到链表的头部
        Node newNode = new Node(key,value);
        newNode.next = list;
        array[index] = newNode;
        size++;
        if(size * 1.0 / array.length >= LOAD_FACTOR){
            resize();
        }
    }

    private void resize() {
        Node[] newArray = new Node[array.length * 2];
        //把原来Hash表中的内容搬运到新数组中
        for (int i = 0; i < array.length; i++) {
            for(Node cur = array[i];cur != null;cur = cur.next){
                int index = cur.key % newArray.length;
                Node newNode = new Node(cur.key,cur.value);
                newNode.next = newArray[index];
                newArray[index] = newNode;
            }
        }
        //新数组代替原来的数组
        array = newArray;
    }

    private int hashFunc(int key) {
        return key % array.length;
    }

    public Integer get(int key){
        //根据key查找指定下标,找到返回value,没找到返回null
        //1.先计算key的对应下标
        int index = hashFunc(key);
        //2.根据下标找到对应的链表
        Node list = array[index];
        //3.在链表中查找指定元素
        for(Node cur = list;cur != null;cur = cur.next){
            if(cur.key == key){
                return cur.value;
            }
        }
        return null;
    }
}
