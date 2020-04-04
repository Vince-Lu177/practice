package practice.practice.JavaTest;


import java.util.ArrayList;
import java.util.List;

public class levelOrder {
    class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //二叉树的分层遍历
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    //result相当于一个二维数组，针对ArrayList来说，每一层又是个一维数组
    public List<List<Integer>> levelOrder(TreeNode root){
        //把每层的节点放在一个List中，用递归来解决
        if(root == null){
            return result;
        }
        //helper方法辅助递归，第二个参数表示当前的层数，从0开始计算，和List的下标对应
        helper(root,0);
        return result;
    }

    private void helper(TreeNode root, int level) {
        if(level == result.size()){
            result.add(new ArrayList<>());
        }
        //把当前节点添加到result的适当位置
        result.get(level).add(root.val);
        if(root.left != null){
            helper(root.left,level + 1);
        }
        if(root.right != null){
            helper(root.right,level + 1);
        }
    }
}
