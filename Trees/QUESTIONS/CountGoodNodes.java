package QUESTIONS;

public class CountGoodNodes {

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
    int res = 0;

    public void helper(TreeNode root , int maxi){
        if(root == null) return;
        if(root.val >= maxi){
            maxi = root.val;
            res++;
        }
        helper(root.left, maxi);
        helper(root.right, maxi);
    }

    public int goodNodes(TreeNode root) {
        helper(root,Integer.MIN_VALUE);
        return res;
    }

}
