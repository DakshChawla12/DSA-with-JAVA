
public class MaxDepthOf_BT {

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

    public int getMaxDepth(TreeNode node , int depth){
        if(node == null) return 0;
        int leftDepth = getMaxDepth(node.left,depth+1);
        int rightDepth = getMaxDepth(node.right,depth+1);
        return Math.max(leftDepth,rightDepth)+1;
    }

    public int maxDepth(TreeNode root) {
        return getMaxDepth(root,0);
    }

}
