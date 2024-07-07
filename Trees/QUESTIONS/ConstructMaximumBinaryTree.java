package QUESTIONS;

public class ConstructMaximumBinaryTree {

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

    public TreeNode helper(int[]arr , int s , int e){
        if(s > e) return null;

        int maxi = Integer.MIN_VALUE;
        int idx = -1;

        for(int i = s; i <= e; i++){
            if(arr[i] > maxi){
                maxi = arr[i];
                idx = i;
            }
        }

        TreeNode res = new TreeNode(maxi);
        res.left = helper(arr,s,idx-1);
        res.right = helper(arr,idx+1,e);

        return res;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

}
