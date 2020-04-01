package practice.practice.JavaTest;

class Node{
    public char val;
    public Node left;
    public Node right;
    public Node(char val) {
        this.val = val;
    }
}

public class BinaryTree {
    public static Node build() {
        //手动构造出一棵树
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = g;
        g.right = h;
        c.right = f;
        return a;
    }

    //前序遍历
    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val + "");
        preorder(root.left);
        preorder(root.right);
    }

    //中序遍历
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    //后序遍历
    public static void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.val);
    }

    //求二叉树中节点的个数
    //用后序遍历的方法
    public static int size(Node root) {
        if (root == null) {
            return 0;
        }
        //访问根节点：计数器 + 1
        //整个树的节点个数 = 根节点的个数(1) + 左子树节点的个数 + 右子树节点的个数
        return 1 + size(root.left) + size(root.right);
    }

    //求二叉树叶子节点的个数
    //叶子节点的个数 = 左子树叶子节点的个数 = 右子树叶子节点的个数
    public static int leafsize(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            //此时root没有子树，root就是叶子节点
            return 1;
        }
        return leafsize(root.left) + leafsize(root.right);
    }

    //求二叉树第K层节点的个数
    //如果K < 1,只能是空数
    //如果K = 1,就是求根节点的数目，1
    //如果K > 1,第K层节点的个数 = K - 1层左子树的个数 + K - 1层右子树的个数
    public static int KLevelSize(Node root, int k) {
        if (root == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return KLevelSize(root.left, k - 1) + KLevelSize(root.right, k - 1);
    }

    //在二叉树中查找指定位置
    //如果存在，返回该节点的引用，如果不存在，就返回null
    public static Node find(Node root, char toFind){
        if(root == null){
            return null;
        }
        if(root.val == toFind){
            return root;
        }
        //递归遍历左子树
        Node result = find(root.left,toFind);
        if(result != null){
            return result;
        }
        return find(root.right,toFind);
    }
}

