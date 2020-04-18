package practice.practice.JavaTest;

import java.util.Stack;

class MinStack {
    //实现最小栈，且时间复杂度为O(1)---用空间换时间
    //创建两个栈A B，A中按正常栈的规则插入删除元素
    //B存放的是当前栈的最小值
    //B里插入元素，是取当前B的栈顶元素和A的新元素进行比较取最小值，插入到B中，需要时刻保证B中插入的值是当前A中的最小值
    //此时无论对A进行啥操作，B的栈顶元素始终表示A中的最小元素的值
    //实现入栈操作：对于A，直接入栈，对于B，把当前元素和B的栈顶元素进行比较，把最小值入栈
    //实现出栈操作：A B同时出栈
    //实现取栈顶元素：取A的栈顶元素
    //实现取最小值：取B的栈顶元素
    private Stack<Integer> A = new Stack<>();
    private Stack<Integer> B = new Stack<>();

    //入栈
    public void push(int x) {
        A.push(x);
        if(B.isEmpty()){
            return;
        }
        int min = B.peek();
        if(x < min){
            min = x;
        }
        B.push(min);
    }

    //出栈
    public Integer pop() {
        if(A.isEmpty()){
            return null;
        }
        B.pop();
        return A.pop();
    }

    //取栈顶元素
    public Integer top() {
        if(A.isEmpty()){
            return null;
        }
        return A.peek();
    }

    //取最小值
    public Integer getMin(){
        if (B.isEmpty()){
            return null;
        }
        return B.peek();
    }
}

