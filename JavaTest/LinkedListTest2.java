package Practice_0503;

public class LinkedListTest2 {
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    //2.反转一个单链表
    public ListNode reverseList(ListNode head){
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

    //3.给定一个带有头结点的非空链表,返回链表的中间节点,如果有两个中间节点,就返回第二个中间节点
    public ListNode middleNode(ListNode head){
        //1.链表为空
        if(head == null){
            return null;
        }
        //2.链表只有一个元素
        if(head.next == null){
            return head;
        }
        //3.处理一般情况
        int steps = getSize(head) / 2;
        ListNode cur = head;
        for(int i = 0;i < steps;i++){
            cur = cur.next;
        }
        return cur;
    }

    //4.输入一个链表,输出该链表的倒数第K个节点
    public ListNode FindKthToTail(ListNode head,int k){
        //1.链表为空
        if(head == null){
            return null;
        }
        //2.k无效
        int size = getSize(head);
        if(k <= 0 || k > size){
            return null;
        }
        int offset = size - k;
        ListNode cur = head;
        for (int i = 0; i < offset; i++) {
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

    //5.1合并两个有序链表,将两个有序链表合并成一个新的有序链表,新链表通过拼接给定两个链表的所有节点组成的
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if(l1 == null){
            //l1为空,最终结果为l2
            return l2;
        }
        if(l2 == null){
            //l2为空,最终结果为l1
            return l1;
        }
        ListNode newHead = null;
        ListNode newTail = null;
        //对于链表尾插,必须要找到链表最后一个节点,为了简化这个过程,就记录链表的尾节点
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while(cur1 != null && cur2 != null){
            if(cur1.val < cur2.val){
                //把cur1对应的节点尾插到新链表的尾部
                //此处还要考虑newTail为空和非空两种情况
                if(newTail == null){
                    newHead = cur1;
                    newTail = cur1;
                }else{
                    newTail.next = cur1;
                    newTail = newTail.next;//更新newTail
                    cur1 = cur1.next;//继续往后遍历
                }
            }else{
                if(newTail == null){
                    newHead = cur2;
                    newTail = cur2;
                }else{
                    newTail.next = cur2;
                    newTail = newTail.next;
                    cur2 = cur2.next;
                }
            }
        }
        //当循环结束的时候,当前的cur1和cur2肯定有一个到达了链表的尾部
        //把另外一个没有到达末尾的剩下所有的元素都连接在链表的尾部
        if(cur1 == null){
            newTail.next = cur2;
        }
        if(cur2 == null){
            newTail.next = cur1;
        }
        return newHead;
    }

    //5.2将两个有序链表合并成一个新的有序链表,新的链表通过拼接给定的两个链表的所有节点--利用傀儡节点解决
    public ListNode mergeTwoLists2(ListNode l1,ListNode l2){
        if(l1 == null){
            //l1为空,最终结果为l2
            return l2;
        }
        if(l2 == null){
            //l2为空,最终结果为l1
            return l1;
        }
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        //对于链表尾插,找到最后一个节点,才能插入,为了简化这个过程,记录新链表的尾部
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while(cur1 != null && cur2 != null){
            if(cur1.val < cur2.val){
                newTail.next = cur1;
                newTail = newTail.next;
                cur1 = cur1.next;
            }else{
                newTail.next = cur2;
                newTail = newTail.next;
                cur2 = cur2.next;
            }
        }
        //当循环结束,说明cur1和cur2一定有一个到达了链表的尾部
        //把另外一个没到末尾的剩下元素都连接在最终链表的尾部
        if(cur1 == null){
            newTail.next = cur2;
        }
        if(cur2 == null){
            newTail.next = cur1;
        }
        return newHead.next;
    }

    //6.编写代码,以给定值为基准,将链表分成两个部分,所有小于基准值的节点都放在大于等于基准值节点之前
    //思路:创建两个链表
    //big:存放所有大于等于基准值的节点
    //small:存放所有小于基准值的节点
    //最后smallTail.next = bigHead.next
    public ListNode partition(ListNode pHead,int x){
        if(pHead == null){
            //链表为空
            return null;
        }
        if(pHead.next == null){
            //链表只有一个元素
            return pHead;
        }
        ListNode smallHead = new ListNode(-1);
        ListNode smallTail = smallHead;
        ListNode bigHead = new ListNode(-1);
        ListNode bigTail = bigHead;
        for(ListNode cur = pHead;cur != null;cur = cur.next){
            if(cur.val < x){
                //插入到smallTail的尾部
                //创建一个新的节点,尾部一定指向null;
                smallTail.next = new ListNode(cur.val);
                smallTail = smallTail.next;
            }else{
                //插入到bigTail的尾部
                bigTail.next = new ListNode(cur.val);
                bigTail = bigTail.next;
            }
        }
        //将两个链表首尾连接在一起
        smallTail.next = bigHead.next;
        return smallHead.next;
    }
}
