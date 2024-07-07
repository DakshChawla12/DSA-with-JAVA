
public class MaxPathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
            
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int ans = Integer.MIN_VALUE;
    public int helper(TreeNode node){
        if(node == null) {
            return 0;
        }

//        int left = helper(node.left);
//        int right = helper(node.right);

        int left = Math.max(0, helper(node.left));
        int right = Math.max(0, helper(node.right));

        int pathSum = left + right + node.val;

        ans = Math.max(ans, pathSum);

        return Math.max(left, right) + node.val;
    }
    public int maxPathSum(TreeNode root) {
        helper(root);
        return ans;
    }

}
