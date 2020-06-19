package Practice_0619;

public class Main {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public void Mirror(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = root.left;
        Mirror(root.left);
        //System.out.println(root.val + "");
        Mirror(root.right);
    }
}
