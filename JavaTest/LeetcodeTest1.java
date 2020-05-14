package Practice_0514;

public class LeetcodeTest1 {
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    //判断是否为回文链表
    public boolean isPalindrome(ListNode head) {
        ListNode cur1 = head;
        ListNode cur2 = head;
        int steps = getSize(head) / 2;
        for (int i = 0; i < steps; i++) {
            cur1 = cur1.next;
        }
        ListNode cur3 = reverse(cur1);
        while(cur3 != null){
            if(cur2.val != cur3.val){
                return false;
            }
            cur2 = cur2.next;
            cur3 = cur3.next;
        }
        return true;
    }

    private ListNode reverse(ListNode cur1) {
        if(cur1 == null){
            return null;
        }
        if(cur1.next == null){
            return cur1;
        }
        ListNode prev = null;
        ListNode newHead = null;
        ListNode cur = cur1;
        while(cur != null){
            ListNode next = cur.next;
            if(next == null){
                newHead  =cur;
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

    //编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
    public ListNode removeDuplicateNodes(ListNode head) {
        if(head == null){
            return null;
        }
        //类似于冒泡排序
        ListNode cur1 = head;
        while(cur1 != null){
            ListNode cur2 = cur1;
            while(cur2.next != null){
                if(cur2.next.val == cur1.val){
                    cur2.next = cur2.next.next;
                }else{
                    cur2 = cur2.next;
                }
            }
            cur1 = cur1.next;
        }
        return head;
    }
}
