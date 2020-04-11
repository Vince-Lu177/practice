package practice.practice.JavaTest;

public class LinkedListInterview {
    //链表笔试题
    class ListNode{
        public ListNode next;
        public int val;

        public ListNode(int val) {
            this.val = val;
        }
    }

    //1.删除链表中等于给定值val的所有节点
    public ListNode removeElements(ListNode head,int val){
        //先判定是否为空链表
        if(head == null){
            return null;
        }
        ListNode prev = head;
        ListNode cur = head.next;
        //删除非头结点的情况
        while(cur != null){
            if(cur.val == val){
                prev.next = cur.next;
                cur = prev.next;
            }else{
                prev = cur;
                cur = cur.next;
            }
            //删除头结点
            if(head.val == val){
                head = head.next;
            }
        }
        return head;
    }

    //2.反转一个单链表
    public ListNode reverseList(ListNode head){
        //先判定链表是否为空
        if(head == null){
            return null;
        }
        //如果链表只有一个元素
        if(head.next == null){
            return head;
        }
        //处理一般情况
        ListNode newHead = null;
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            //next记录cur下一个位置
            ListNode next = cur.next;
            if(next == null){
                //cur为最后一个节点
                //cur为新链表的头结点
                newHead = cur;
            }
            //cur下一个节点指向前一个位置，达到反转的目的
            cur.next = prev;
            //同步更新prev和cur
            prev = cur;
            cur = next;
        }
        return newHead;
    }

    //3.给定一个带有头结点的非空链表，返回链表的中间节点，如果有两个中间节点，则返回第二个中间节点
    public ListNode middleNode(ListNode head){
        //判定链表是否为空
        if(head == null){
            return null;
        }
        //链表只有一个元素
        if(head.next == null){
            return head;
        }
        int steps = getSize(head) / 2;
        //steps即要往后走的步数
        ListNode cur = head;
        for (int i = 0; i < steps; i++) {
            cur = cur.next;
        }
        return cur;
    }

    private int getSize(ListNode head) {
        int size = 0;
        for(ListNode cur = head;cur != null;cur = cur.next){
            size++;
        }
        return size;
    }

    //4.输入一个链表，输出该链表的倒数第k个元素
    public ListNode FindKthToTail(ListNode head,int k) {
        //判断是否为空链表
        if(head == null){
            return null;
        }
        int size = getSize(head);
        //判断k是否有效
        if(k <= 0 || k > size){
            return null;
        }
        //获取到要往后走的步数
        int offset = size - k;
        ListNode cur = head;
        for (int i = 0; i < offset; i++) {
            cur = cur.next;
        }
        return cur;
    }
}
