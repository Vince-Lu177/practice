package practice.practice.JavaTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetMapInterview {
    //1.只出现一次的数字
    //给定一个非空数组，除某个元素只出现一次之外，其他元素都出现两次，找出那个出现一次的数字
    //方法一：通过Map统计每个元素出现的次数，再次遍历Map找到那个只出现一次的数字
    public int singleNumber(int[] nums){
        //1.创建一个map统计每个次数出现的次数
        Map<Integer,Integer> map = new HashMap<>();
        //2.遍历数组来完成统计
        for (int x : nums){
            Integer value = map.get(x);
            if(value == null){
                //当这个数字在map中不存在，就新建一个键值对
                map.put(x,1);
            }else{
                //这个数字已经存在，把value + 1
                map.put(x,value + 1);
            }
        }
        //3.遍历这个数组，找到出现次数为一的元素
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            //getValue得到的是Integer包装类，通过.equals判断相等，相当于进行了自动装箱，比较两个Integer的值
            //如果写成==，相当于对Integer进行了自动拆箱，比较相等
            if(entry.getValue().equals(1)){
                return entry.getKey();
            }
        }
        return 0;
    }
    //方法二：按位异或的方法
    //a = a ^ b ^ b;
    //把初始值为0的数和数组中所有的元素异或，元素值相等的两个元素异或之后就相互抵消了，所有的元素都异或之后，最后的数字就是只出现一次的元素
    public int singleNumber2(int[] nums){
        int ret = 0;
        for(int x : nums){
            ret ^= x;
        }
        return ret;
    }

    //2.复制带随机指针的链表
    //给定一个链表，包含一个额外增加的随机指针，该指针可以指向链表中任何的节点和空节点
    //要求返回这个链表的深拷贝
    //创建一个Map<Node,Node>,key表示旧链表上的节点，value表示旧链表对应节点的拷贝，即新链表的头节点
    //新1 = 旧1
    //新1.next = 旧1.next
    //新1.random = 旧1.next
    class Node{
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = next;
            this.random = random;
        }


    }
    public Node copyRandomList(Node head){
        //1.遍历旧链表把旧链表每个节点依次插入到map中，key表示旧链表上的节点，value表示旧链表对应节点的拷贝
        Map<Node,Node> map = new HashMap<>();
        for(Node cur = head;cur != null;cur = cur.next){
            map.put(cur,new Node(cur.val));
        }
        //2.再次遍历链表，修改链表中的next和random的
        for(Node cur = head;cur != null;cur = cur.next){
            Node newcur = map.get(cur);
            newcur.next = map.get(cur.next);
            newcur.random = map.get(cur.random);
        }
        //需要返回新链表的头结点
        return map.get(head);
    }

    //3.宝石与石头
    //给定字符串J代表宝石的类型，字符串S代表拥有的石头，J中元素不重复，S中字符串都是字母，字母区分大小写，求出S中宝石的个数
    public int numJewelsInStones(String J, String S) {
        //1.先遍历J中所有宝石加入一个Set中
        Set<Character> set = new HashSet<>();
        for(char c : J.toCharArray()){
            set.add(c);
        }
        //遍历S拿到的每个元素去set中查找，如果能找到，就说明是宝石
        int ret = 0;
        for(char c : S.toCharArray()) {
            if (set.contains(c)) {
                ret++;
            }
        }
        return ret;
    }
}
