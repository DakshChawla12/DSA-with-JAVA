package QUESTIONS;

public class LargestBst {

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

    public  class NodeValue{
        public int maxValue , minValue , maxSize;
        NodeValue(int maxi , int mini , int size){
            this.maxValue = maxi;
            this.minValue = mini;
            this.maxSize = size;
        }
    }

    public NodeValue helper(TreeNode root){
        if(root == null){ // an empty tree of size 0
            return new NodeValue(Integer.MIN_VALUE , Integer.MAX_VALUE , 0);
        }
        NodeValue Left = helper(root.left);
        NodeValue Right = helper(root.right);

        if(root.val > Left.maxValue && root.val < Right.minValue){ // current node is greater than maximum at left and smaller than minimum at right it is a BST
            return new NodeValue(Math.min(root.val,Left.minValue) , Math.max(root.val, Right.maxValue) , Left.maxSize+ Right.maxSize+1);
        }
        // otherwise return [infinity,-infinity] so parent can't be a valid bst
        return new NodeValue(Integer.MAX_VALUE , Integer.MIN_VALUE , Math.max(Left.maxSize,Right.maxSize));
    }

    public int largestBst(TreeNode root){
        return helper(root).maxSize;
    }
}
