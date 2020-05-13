package Practice_0513;

class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
public class LeetcodeTest {
    //给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //判断是否为空节点
        if(head == null){
            return null;
        }
        int size = getSize(head);
        //判断n是否合法
        if(n <= 0 || n > size){
            return null;
        }
        int offset = size - n;
        ListNode cur = new ListNode(0);
        cur.next = head;
        ListNode prev = cur;
        while(offset > 0){
            offset--;
            prev = prev.next;
        }
        //循环结束,prev指向被删除元素的前一个元素
        prev.next = prev.next.next;
        return cur.next;
    }

    private int getSize(ListNode head) {
        int size = 0;
        for(ListNode cur = head; cur != null;cur = cur.next){
            size++;
        }
        return size;
    }
    //实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
    public int kthToLast(ListNode head, int k) {
        int Size = getSize(head);
        int offset = Size - k;
        ListNode cur = head;
        for (int i = 0; i < offset; i++) {
            cur = cur.next;
        }
        return cur.val;
    }
}
