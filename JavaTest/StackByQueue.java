package Practice_0330;

import java.util.LinkedList;
import java.util.Queue;

public class StackByQueue {
    //用两个队列模拟实现一个栈的效果
    //创建两个队列AB
    //1.入栈：把新元素往A中入队列即可
    //2.出栈：把A队列的元素往B中搬运，当A只剩一个的元素的时候，直接出队列即可。然后交换AB，保证新入栈的元素往A中加入
    //3.取栈顶元素：和出栈类似
    //4.判空：AB都为空
    private Queue<Integer> A = new LinkedList<>();
    private Queue<Integer> B = new LinkedList<>();

    //入栈
    public void push(int x){
        //x往A中入队列即可
        A.offer(x);
    }

    //出栈
    public Integer pop(){
        if(empty()){
            return null;
        }
        //把A中元素往B中搬运
        while(A.size() > 1){
            Integer front = A.poll();
            B.offer(front);
        }
        //当循环结束A中只有一个元素，这个元素就应该被出栈
        int ret = A.poll();
        //交换AB
        swap();
        return ret;
    }

    //取栈顶元素
    public Integer peek(){
        if(empty()){
            return null;
        }
        //把A中元素往B中搬运
        while(A.size() > 1){
            Integer front = A.poll();
            B.offer(front);
        }
        //当循环结束A中只有一个元素，这个元素就应该被取出
        int ret = A.poll();
        B.offer(ret);
        //交换AB
        swap();
        return ret;
    }
    private void swap(){
        Queue<Integer> tmp = A;
        A = B;
        B = tmp;
    }

    //判空
    public boolean empty(){
        return A.isEmpty() && B.isEmpty();
    }
}
