package Practice_0626;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Main2 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isBalance(TreeNode root) {
        // write code here
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return false;
        }
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        if (leftMaxDepth - rightMaxDepth > 1 || rightMaxDepth - leftMaxDepth > 1) {
            return false;
        }
        return true;

    }

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left, right);
    }
}
