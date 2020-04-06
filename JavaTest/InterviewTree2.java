package practice.practice.JavaTest;

public class InterviewTree2 {
    //给定一颗二叉树，找到该树两个指定节点的最近公共祖先(一个节点认为也可以是自己的祖先)
    //借助递归，用一个辅助方法进行递归，按照后序遍历的方式，尝试查找p和q
    //如果从某个节点开始，后序遍历的时候能够把p q都找到，说明该节点是p q的祖先
    //如果从某个节点开始，后序遍历的时候能够把p q都找到，并且p q不在同一个子树中，说明该节点是p q的最近公共祖先
    //p和q可能出现在三个位置，左子树，右子树，当前节点中
    //如果p和q分布在三个位置中的两个，就认为该节点就是最近公共祖先

    //二叉搜索树转换成排序双向链表
    //输入一颗二叉搜索树，将该二叉搜索树装换成一个排序的双向链表(不能创建新的节点，只能改变整棵树中节点的指向)
    //解决这个问题的关键：中序排列
    //left上一个节点，right指向下一个节点
    public TreeNode Convert(TreeNode pRootOfTree) {
        //基于递归的方法来完成双向链表构建，为保证有序性，需要进行中序遍历
        //二叉搜索树中序遍历结果是有序的
        if(pRootOfTree == null){
            return null;
        }
        if(pRootOfTree.left == null && pRootOfTree.right == null){
            //当前节点没有子树
            return pRootOfTree;
        }
        //最终的链表：左子树的链表 + 根节点 + 右子树的链表，左子树的尾部和右子树的头部与跟节点相连
        //1.先递归处理左子树
        TreeNode left = Convert(pRootOfTree.left);
        //left是左子树链表的根节点
        //2.需要找到左子树链表的尾节点
        TreeNode leftTail = left;
        while(leftTail != null && leftTail.right != null){
            //right相当于链表的next
            leftTail = leftTail.right ;
        }
        //循环结束之后，left.Tail就指向了左侧链表的尾部
        //3.把左子树和当前节点连接在一起
        if(left != null){
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        //4.递归转换左子树，把左子树转换成双向链表
        TreeNode right = Convert(pRootOfTree.right);
        //5.把当前节点与左子树相连
        if(right != null){
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        //最终返回新链表的头结点
        ///如果left为空，链表的头结点就是pRootOfTree
        //如果头结点非空，链表的头结点就是left
        return left == null ? pRootOfTree : left;
    }
}
