package practice.practice.JavaTest;

import java.util.Stack;

public class InterviewTree3 {
    class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //二叉树的非递归遍历--需要手动模拟递归的过程

    //先序遍历
    //1.首先准备一个栈，根节点入栈，循环取栈顶元素，同时出栈，并访问栈顶元素
    //2.判断当前节点的右子树是否为空，非空入栈
    //3.判断当前节点的左子树是否为空，非空入栈
    //4.当栈为空的时候，遍历结束
    public static void preorderByLoop(TreeNode root){
        if(root == null){
            return;
        }
        //创建一个栈
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode top = stack.pop();
            //访问这个节点
            System.out.print(top.val + " ");
            //把右子树和左子树分别入队列
            if(top.right != null){
                stack.push(top.right);
            }
            if(top.left != null){
                stack.push(top.left);
            }
        }
    }

    //中序遍历--借助栈来模拟递归的过程
    //1.先从root出发(此时还不能访问)，向左找路上遇到所有的元素纷纷入栈，直到找到左子树为空
    //2.到达最左侧，取栈顶元素同时出栈，并访问这个元素
    //3.把刚才的栈顶元素的右子树作为起点，再次循环往左找，路径上遇到的元素纷纷入栈
    public static void inorderByLoop(TreeNode root){
        if(root == null){
            return;
        }
        //创建一个栈
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(true){
            //1.循环往左找，把路上遇到的所有元素都入栈
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            //2.如果栈为空，遍历就结束了
            if(stack.isEmpty()){
                break;
            }
            //3.取栈顶元素，并访问
            TreeNode top = stack.pop();
            System.out.print(top.val + " ");
            //4.从当前节点的右子树出发，重复以上步骤
            cur = top.right;
        }
    }

    //后序遍历--借助栈来模拟递归的过程
    //1.从root出发，路上遇到的非空节点，纷纷入栈
    //2.循环取出栈顶元素(不是pop，而是peek)，此时栈顶元素能否访问，还得看下一步的判断
    //a)如果栈顶元素没有右子树，可以访问 + pop
    //b)如果栈顶元素的右子树已经被访问过了(看上一个访问的元素是否为右子树)，可以访问 + pop
    //3.从该节点的右子树出发，重复以上操作
    public static void postorderByLoop(TreeNode root){
        if(root == null){
            return;
        }
        //创建一个栈
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        //prev记录已访问过元素的最后一个元素
        while(true){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            if(stack.isEmpty()){
                break;
            }
            //拿出栈顶元素，看是否能访问
            TreeNode top = stack.peek();
            if(top.right == null || prev == top.right) {
                //此时说明可以访问，这个条件对应a)b)
                System.out.print(top.val + " ");

                stack.pop();
                prev = top;
                //此时时刻维护好prev指向要访问元素的前一个元素
            }else {
                cur = top.right;
            }
        }
    }
}
