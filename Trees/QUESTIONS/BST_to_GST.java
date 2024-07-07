package QUESTIONS;

public class BST_to_GST {

    public static class TreeNode {
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

    int sum = 0;
    public void helper(TreeNode node){
        if(node == null) return;
        helper(node.right);
        sum += node.val;
        node.val = sum;
        helper(node.left);
    }

    public TreeNode bstToGst(TreeNode root) {
        helper(root);
        return root;
    }

}
