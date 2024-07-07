import java.util.*;

public class LevelOrderSuccessor {

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

    public TreeNode getLevelOrderSuccessor(TreeNode root , int value){
        if(root == null) return null;
        Queue<TreeNode>q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left != null) q.offer(curr.left);  
            if(curr.right != null) q.offer(curr.right);
            if(curr.val == value) break;
        }
        return q.poll();
    }

}