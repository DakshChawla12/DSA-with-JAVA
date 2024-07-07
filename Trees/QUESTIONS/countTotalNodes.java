
public class countTotalNodes {

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

    public int helper(TreeNode node , int count){
        if(node == null) return 0;

        int l = helper(node.left,count+1);
        int r = helper(node.right,count+1);

        return l+r+1;
    }
    
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int count = 1;
        return helper(root,count);
    }

}
