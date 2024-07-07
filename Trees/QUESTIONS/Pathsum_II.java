package QUESTIONS;
import java.util.*;
public class Pathsum_II {

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

    public boolean isLeaf(TreeNode node){
        return (node.left == null) && (node.right == null);
    }

    public void helper(TreeNode root, List<List<Integer>> ls, int target, List<Integer> ds, int currSum) {
        if (root == null) return;
        currSum += root.val;
        ds.add(root.val);
        if (isLeaf(root) && currSum == target) {
            ls.add(new ArrayList<>(ds));
            ds.removeLast();
            return;
        }
        helper(root.left, ls, target, ds, currSum);
        helper(root.right, ls, target, ds, currSum);
        ds.removeLast();
    }


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>ls = new ArrayList<>();
        helper(root,ls,targetSum,new ArrayList<Integer>(),0);
        return ls;
    }

}
