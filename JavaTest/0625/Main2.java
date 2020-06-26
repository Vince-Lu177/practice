package Practice_0625;


public class Main2 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode plusAB(ListNode a, ListNode b) {
        ListNode res = new ListNode(-1);
        if (a == null && b == null) {
            return null;
        }
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        int aSize = getSize(a);
        int bSize = getSize(b);
        ListNode aCur = a;
        ListNode bCur = b;
        ListNode resCur = b;

        while(a!=null&&b!=null){
            res.next = new ListNode(a.val+b.val);
            a = a.next;
            aCur = a;
            b = b.next;
            bCur = b;
            resCur = res.next;
        }
        if(aSize>bSize){
            resCur = aCur;
        }
        if(aSize<bSize){
            resCur = bCur;
        }
        ListNode cur = resCur;
        ListNode next = cur.next;
        while (next!=null){
            if(cur.val>=10){
                cur.val%=10;
                next.val++;
            }
            cur = next;
            next = next.next;
        }
        if(next.val<10){
            cur.next = next;
        }else{
            cur.next = new ListNode(next.val%10);
            cur.next.next = new ListNode(1);
        }

        return reverseList(cur);
    }

    private static int getSize(ListNode head) {
        int size = 0;
        for (ListNode cur = head; cur != null; cur = cur.next){
            size++;
        }
        return size;
    }
    public static ListNode reverseList(ListNode head){
        //1.链表为空
        if(head == null){
            return null;
        }
        //2.链表只有一个元素
        if(head.next == null){
            return head;
        }
        //3.处理一般情况
        ListNode newHead = null;
        ListNode cur = head;
         ListNode prev = null;
        while (cur != null){
            //用next记录cur的下一个节点
             ListNode next = cur.next;
            if(next == null){
                //当前cur已经是最后一个节点了,即为反转之后链表的头结点
                newHead = cur;
            }
            cur.next = prev;
            //同步更新cur和prev的位置
            prev = cur;
            cur = next;
        }
        return newHead;
    }

}
