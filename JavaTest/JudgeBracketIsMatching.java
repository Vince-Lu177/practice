package Practice_0328;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class JudgeBracketIsMatching {
    //括号匹配问题
    //分析：遍历字符串依次取出字符
    //1.如果当前字符是左括号([{,就把当前字符入栈
    //2.如果当前字符是右括号)]},取出栈顶元素，检查和当前的括号类型是否匹配
    //i.如果匹配，把栈顶元素出栈，继续取下一个元素
    //ii.如果类型不匹配，返回false
    //3.遍历完整个字符串之后，检查栈是否为空栈，如果是空栈，说明合法，否则就是非法
    //应用：处理多层括号嵌套的问题
    public boolean JudgeBracketIsMatching(String s){
        //key表示左括号，value表示有括号
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        //1.先创建一个栈，保存字符类型
        Stack<Character> stack = new Stack<>();
        //2.循环遍历字符串中的每个字符，取出每个字符
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            //3.判定是否为括号 注：如果是做LeetCode题的话，不需要额外考虑，题目会说明
            if (c != '(' || c != ')' || c != '[' || c != ']'|| c != '{' || c != '}' ){
                return false;
            }
            //4.判定c是否为左括号，如果是，就入栈
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
                continue;
            }
            if(stack.empty()){
                //如果当前字符不是左括号，且栈为空，此时说明字符串为非法
                //这种情况说明，没有合适的的左括号与当前括号匹配
                return false;
            }
            //5.判定c是否为右括号，如果是，就取出栈顶元素对比一下
            char top = stack.pop();
            if(map.get(top) == c){
                continue;
            }
            //除了上面三个合法情况，其余都是非法的
            return false;
        }
        //检查栈是否为空，空栈说明合法
        if(stack.empty()){
            return true;
        }
        return false;
    }
}
