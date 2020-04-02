package Practice_0402;



import java.util.ArrayList;
import java.util.List;

class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}


public class InterviewTree {
    //二叉树的前序遍历
    public List<Integer> preOrderTravalsal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            //空树返回一个空的List（元素为0，但不是null）
            return result;
        }
        //访问根节点，把元素添加到List中
        result.add(root.val);
        //遍历左子树，把遍历的结果加入到List中
        result.addAll(preOrderTravalsal(root.left));
        //遍历右子树，把遍历的结果加入到List中
        result.addAll(preOrderTravalsal(root.right));
        return result;
    }

    //二叉树的中序遍历
    public List<Integer> inOrderTravalsal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            //空树返回一个空的List;
            return result;
        }
        //遍历左子树，把遍历的结果加入到List中
        result.addAll(inOrderTravalsal(root.left));
        //访问根节点，把元素添加到List中
        result.add(root.val);
        //遍历右子树，把遍历的结果加入到list中
        result.addAll(inOrderTravalsal(root.right));
        return result;
    }

    //二叉树的后序遍历
    public List<Integer> postOrderTravalsal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            //空树返回一个空的List
            return result;
        }
        //遍历左子树，把遍历的结果加入到List中
        result.addAll(inOrderTravalsal(root.left));
        //遍历右子树，把遍历的结果加入到List中
        result.addAll(inOrderTravalsal(root.right));
        //访问根节点，把元素添加到List中
        result.add(root.val);
        return result;
    }

    //检查两棵树是否相同
    //比较A B是否相同 == 根节点的值是否相同 && 左子树相同(A.left == B.left) && 右子树相同(A.right == B.right)
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //分成四种情况
        //1.p q都为null
        //2.p为null，q不为null
        //3.p不为null，q为null
        //4.p q都不为null
        if (p == null && q == null) {
            //两树都为空树，认为是相同的
            return true;
        }
        if (p == null || q == null) {
            //由于上面的逻辑，p q不会同时为null，只能一个为null，一个不为null
            return false;
        }
        //下面是处理都不为null的情况
        //先判定根节点是否相同
        if(p.val != q.val){
            //这两棵树一定不相等
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    //另一棵树的子树
    //判断一个树是否为另一个树的子树，本质上就是判断一个树和另一个数的子树是否相等
    //s是否包含t == s t是否相等 || s.left是否包含t || s.right是否包含t
    public boolean isSubTree(TreeNode s,TreeNode t){
        if(s == null && t == null){
            return true;
        }
        if(s == null || t == null){
            return false;
        }
        return isSameTree(s,t) || isSubTree(s.left,t) || isSubTree(s.right,t);
    }

    //求二叉树的深度
    //深度 == max(左子树的深度，右子树的深度) + 1
    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        //return 1 + (maxDepth(root.left) > maxDepth(root.right) ? maxDepth(root.left) : maxDepth(root.right));
        //递归需要执行三次，效率比较低
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);
    }

    //平衡二叉树：一个树每个节点的左右子树的高度差不超过1
    //1.空树或者没有子树，平衡
    //2.针对当前节点，求左右子树的高度差是否大于1
    //3.递归判定该树的左右子树是否平衡
    //isBalanced == 左右子树的高度差小于1 && 左子树平衡 && 右子树平衡
    public boolean isBalanced(TreeNode root){
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if(leftDepth - rightDepth > 1 || rightDepth - leftDepth > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    //对称二叉树：给定一个二叉树，检查是否为镜像对称的
    //判断一棵树是否对称：左子树A和右子树B是否为镜像关系 == A 和 B的根节点是否相同 && A.left 和 B.right是否为镜像关系
    //&& A.right 和 B.left 是否为镜像关系
    public boolean isSymmetric(TreeNode root){
        if(root == null ){
            return true;
        }
        return isMirror(root.left,root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null){
            return true;
        }
        if(t1 == null || t2 == null){
            //一个为空，一个非空
            return false;
        }
        if(t1.val != t2.val){
            //两个树的根节点不同，肯定不是镜像关系
            return false;
        }
        return isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left);
    }

}
