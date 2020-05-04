package Practice_0504;

import LinkedList.LinkedList;

public class LinkedListTest3 {
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    //1.删除有序链表中的重复节点,重复节点不保留,返回链表头结点
    //分析:链表有序,说明重复节点相邻
    //目标:识别当前节点是否为重复节点
    //如果不是重复节点接把该节点尾插到新链表的结尾
    //遇到重复节点,直接跳过
    //从头节点循环往后找,一直找到cur和cur.next不相等了,就说明到达了这片重复元素的末尾了
    public ListNode deleteDuplicates(ListNode head){
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        ListNode cur = head;
        //循环遍历链表
        while(cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                //说明cur指向的元素是重复元素,接下来就需要找到这片重复的末尾
                //然后跳过这个重复区间
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                //while循环结束,cur就指向这片相同元素的末尾了
                //再往后走一步就跳过了重复区间
                cur = cur.next;
            } else {
                //说明cur指向的元素不是重复元素,直接尾插到新链表的结尾
                newTail.next = new ListNode(cur.val);
                newTail = newTail.next;
                cur = cur.next;
            }
        }
        return newHead.next;
    }

    //2.链表的回文结构
    //对于一个链表,请设计一个时间复杂度为O(n),空间复杂度为O(1)的算法,判断链表是否为回文结构
    //1.先找到链表的中间节点
    //2.从中间节点开始,对后半个链表进行逆置操作
    //3.从两个(半个)链表的开头依次遍历比较即可
    public boolean isPalindrome(ListNode head) {
        //1.先找到链表的中间节点
        int size  = getSize(head);
        int steps = size / 2;
        ListNode cur1 = head;
        ListNode cur2 = head;
        for (int i = 0; i < steps; i++) {
            cur2 = cur2.next;
        }
        //循环结束cur2就指向了cur1的中间位置
        //2.对cur2链表进行逆置
        ListNode cur3 = reverseList(cur2);
        //3.分别从cur1和cur3出发依次对比两个链表元素对应相等
        //如果链表长度为奇数个,cur1和cur3长度相等,此时无影响
        //如果链表长度为偶数个,cur1比cur3长度长一个,循环结束条件要以cur3为基准
        while(cur3 != null){
            if(cur1.val != cur3.val){
                return false;
            }
            cur1 = cur1.next;
            cur3 = cur3.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode cur2) {
        if(cur2 == null){
            return null;
        }
        if(cur2.next == null){
            return cur2;
        }
        ListNode prev = null;
        ListNode cur = cur2;
        ListNode newHead = null;
        while(cur != null){
            ListNode next = cur.next;
            if(next == null){
                //cur为链表的最后一个元素,更新头结点
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return newHead;
    }

    private int getSize(ListNode head) {
        int size = 0;
        for(ListNode cur = head;cur != null;cur = cur.next){
            size++;
        }
        return size;
    }

    //3.输入两个链表,找到他们相交的起始节点
    public ListNode intersectionNode(ListNode headA,ListNode headB){
        //1.分别求两个链表的长度
        int size1 = getSize(headA);
        int size2 = getSize(headB);
        //2.算出差值,为长链表要走的步数
        if(size1 > size2){
            for (int i = 0; i < size1 - size2; i++) {
                headA = headA.next;
            }
        }else{
            for (int i = 0; i < size2 - size1; i++) {
                headB = headB.next;
            }
        }
        //3.此时headA和headB已经在同一起点了
        while(headA != null && headB != null){
            if(headA == headB){
                //节点相同,该节点即为相交的节点
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        //节点不相交
        return null;
    }

    //4.给定一个链表,判断表中是否有环
    //思路:创建两个指针 fast slow
    //fast每次走两步,slow每次走一步
    //如果链表带环,fast和slow一定重合,fast和slow不重合,说明不带环
    public boolean hasCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    //5.给定一个链表,返回链表开始入环的第一个节点,若链表不带环,返回null
    public ListNode detectCycle(ListNode head){
        //1.使用快慢指针,找到快慢指针的交点
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                //链表带环
                break;
            }
        }
        if(fast == null || fast.next == null){
            //链表不带环
            return null;
        }
        //带环的情况,设定两个引用,分别从链表的head位置和fast位置开始,按照相同的速度走
        ListNode cur1 = head;
        ListNode cur2 = fast;
        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2  =cur2.next;
        }
        //该位置就是环的入口
        return cur1;
    }

    public static void main(String[] args) {
        LinkedListTest3 test = new LinkedListTest3();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(1);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;
        boolean res = test.isPalindrome(a);
        System.out.println(res);
    }
}
