import java.util.*;

public class checkEvenOddTree {
    
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

    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode>q = new LinkedList<>();
        int level = 0;
        q.add(root);
        while(!q.isEmpty()){
            int idx = q.size();
            int prev = level % 2 == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for(int i = 0; i < idx; i++){
                TreeNode curr = q.poll();
                if ((level % 2 == 0 && (curr.val % 2 == 0 || curr.val <= prev)) ||
                    (level % 2 != 0 && (curr.val % 2 != 0 || curr.val >= prev))) {
                    return false;
                }
                prev = curr.val;
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            level++;
        }
        return true;
    }

}
