package Practice_0603;


import java.util.Map;
import java.util.Stack;

public class exam {
    public boolean chkParenthesis(String A, int n) {
        if( n % 2 != 0){
            return  false;
        }

        Stack<Character> stack = new Stack();
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if(c == '('){
                stack.push(c);
                continue;
            }
            if(stack.empty()){
                return false;
            }
            char top = stack.pop();
            if(top == ')') {
                continue;
            }
        }
        if(stack.empty()){
            return true;
        }
        return false;
    }


}