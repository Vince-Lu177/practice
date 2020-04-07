package practice.practice.JavaTest;

public class Tree2str {
    class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //二叉树创建字符串
    //根据先序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串，空节点则用一对空括号"()"表示
    //而且你需要省略所有不影响字符与原始二叉树之间的一对一的映射关系的空括号对
    //括号省略的注意事项：
    //1.如果一个树的左右子树都为空，括号可以省略
    //2.如果一个树的左子树为空，右子树不为空，括号不可以省略
    //3.如果一个树的右子树为空，左子树不为空，括号可以省略
    private StringBuilder sb = new StringBuilder();
    //使用sb表示最终得到字符串的结果
    //递归过程中得到的局部结构都往sb中追加
    public String tree2str(TreeNode t){
        if(t == null){
            //空树返回一个空的字符串
            return "";
        }
        //借助helper方法递归进行前序遍历
        helper(t);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void helper(TreeNode t) {
        if(t == null){
            return;
        }
        //访问根节点，此处的访问把访问操作追加到sb中即可
        sb.append("(");
        sb.append(t.val);
        helper(t.left);
        if(t.left == null && t.right != null){
            sb.append("()");
        }
        helper(t.right);
        sb.append(")");
    }
}
