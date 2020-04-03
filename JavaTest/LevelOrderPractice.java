package practice.practice.JavaTest;


import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderPractice{
    class Node{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public Node(int val) {
            this.val = val;
        }
    }
    public void levelOrder(TreeNode root){
        //此处不能使用递归来解决了
        //可以借助一个队列来解决
        //初始情况下，创建一个空队列，并且把根节点加入队列中，循环取出队首元素，访问该元素
        //当前元素左子树如果非空，就入队列，右子树非空，也入队列
        Queue <TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            System.out.print(cur.val + " ");
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
    }

    //判断是否为完全二叉树
    //完全二叉树，在进行层序遍历的时候，需要引入一个标志位，来区分当前的两个阶段
    //1.任何一个节点，一定有两个子树。当遇到某个节点，只有左子树或没有子树的时候，就会切换到第二个阶段
    //如果遇到某个子树只有右子树，那么这个树肯定不是完全二叉树
    //2.任何一个节点一定没有子树
    //当我们层序遍历结束之后，整个树满足以上要求，就是完全二叉树
    public boolean isCompleteTree(TreeNode root){
        //针对这个树进行层序遍历
        if(root == null){
            return true;
        }
        boolean isSecondStage = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.isEmpty()){
            TreeNode cur = queue.poll();
            //针对当前节点进行访问，判断是否符合完全二叉树要求
            if(!isSecondStage){
                //这是第一阶段
                if(cur.left != null && cur.right != null){
                    //直接把这两个子树入队列
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }else if(cur.left == null && cur.right != null){
                    //当前阶段某个节点只有右子树，一定不是完全二叉树
                    return false;
                }else if(cur.left != null && cur.right == null){
                    //切换到第二阶段，并且把左子树入队列
                    isSecondStage = true;
                    queue.offer(cur.left);
                }else{
                    //左右子树都为空，也要入队列
                    isSecondStage = true;
                }
            }else{
                //这是第二阶段
                //要求第二阶段的任何一个节点都必须没有子树
                //只要找到某个节点有子树，就返回false
                if(cur.left != null || cur.right != null){
                    return false;
                }
            }
        }
        //整个树都遍历完了，也没有找到反例
        return true;
    }
}
