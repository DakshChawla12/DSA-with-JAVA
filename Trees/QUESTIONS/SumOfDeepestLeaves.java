package QUESTIONS;
import java.util.*;
public class SumOfDeepestLeaves {

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

    public int getMaxDepth(TreeNode node , int depth){
        if(node == null) return 0;
        int leftDepth = getMaxDepth(node.left,depth+1);
        int rightDepth = getMaxDepth(node.right,depth+1);
        return Math.max(leftDepth,rightDepth)+1;
    }

    public int deepestLeavesSum(TreeNode root) {
        int h = getMaxDepth(root,0);
        int k = 1;
        Queue<TreeNode>q = new LinkedList<>();
        q.offer(root);

        while(k < h){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode temp = q.poll();
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
            }
            k++;
        }

        int res = 0;
        while(!q.isEmpty()){
            res += q.poll().val;
        }

        return res;
    }

}
