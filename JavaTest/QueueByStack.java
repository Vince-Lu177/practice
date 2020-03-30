package Practice_0330;

import java.util.Stack;

public class QueueByStack {
    //用两个栈模拟一个队列的情况
    //创建两个栈A B，A专门用来入队列，B专门用来出队列
    private Stack<Integer> A = new Stack<>();
    private Stack<Integer> B = new Stack<>();

    //1.实现入队列：先把B中的元素搬运到A中，然后把新元素往A中入栈即可
    //2.实现出队列：先把A中的元素搬运到B中，然后对B直接出栈即可
    //3.取栈顶元素：先把A中的元素搬运到B中，然后取B的栈顶元素即可
    //4.判空：A B都为空

    //入队列
    public void push(int x){
        //1.把B中元素都搬运到A中
        while(!B.isEmpty()){
            int tmp = B.pop();
            A.push(tmp);
        }
        //把新元素往A中入栈即可
        A.push(x);
    }

    //出队列
    public Integer pop(){
        //1.如果为空直接返回null
        if(empty()){
            return null;
        }
        //2.把A中的元素搬运到B中
        while (A.isEmpty()){
            int tmp = A.pop();
            B.push(tmp);
        }
        //3.针对B进行出栈
        return B.pop();
    }

    //取栈顶元素
    public Integer peek(){
        //1.如果为空，直接返回null
        if(empty()){
            return null;
        }
        //2.把A中的元素搬运到B中
        while(A.isEmpty()){
            int tmp = A.pop();
            B.push(tmp);
        }
        //3.取出B的栈顶元素
        return B.peek();
    }
    //判空
    public boolean empty(){
        return A.isEmpty() && B.isEmpty();
    }
}
