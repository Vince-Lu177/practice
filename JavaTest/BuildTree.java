package practice.practice.JavaTest;

public class BuildTree {
    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //根据一棵树的先序遍历和中序遍历构造二叉树
    //先序遍历：第一个节点一定是根节点，后面的节点是左子树或者右子树的根节点
    //中序遍历：左子树的根节点在左侧，右子树的根节点在右侧
    //基本思路：1.根据先序遍历找到当前树的根节点
    //         2.拿着这个根节点去中序遍历的结果中查找就可以看出哪些是左子树，哪些是右子树
    //借助一个辅助方法递归现需遍历，访问根节点操作为“构造节点”
    //同时给辅助递归的方法加上下标参数，通过下标找到该节点在中序遍历结果中的位置
    //划分左右子树，进一步递归左右子树
    private int index;
    //当前元素在先序遍历中的下标
    public TreeNode buildTree(int[] preorder,int[] inorder){
        index = 0;
        return bulidTreeHelper(preorder,inorder,0,inorder.length);
    }
    //[left,right)这个区间表示当前preorder[index]这个节点对应子树的中序遍历结果
    private TreeNode bulidTreeHelper(int[] preorder, int[] inorder, int left, int right) {
        if(left >= right){
            //中序遍历结果为空，此树为空树
            return null;
        }
        if(index >= preorder.length){
            //遍历结束
            return null;
        }
        //根据根节点的值创建根节点
        TreeNode root = new TreeNode(preorder[index]);
        //根据该节点在中序遍历结果中的位置，把inorder数组分为两个部分
        index++;
        //节点处理完毕，index++处理下一个节点
        int pos = find(inorder,left,right,root.val);
        root.left = bulidTreeHelper(preorder,inorder,left,pos);
        root.right = bulidTreeHelper(preorder,inorder,pos + 1,right);
        return root;
    }

    private int find(int[] inorder, int left, int right, int toFind) {
        for (int i = left; i < right; i++) {
            if(inorder[i] == toFind){
                return i;
            }
        }
        return -1;
    }
}
