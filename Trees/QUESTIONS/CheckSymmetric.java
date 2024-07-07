import java.util.*;

public class CheckSymmetric {
    
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

    public boolean isSymmetric(TreeNode root) {

        if(root == null) return true;
        

        Queue<TreeNode> q = new LinkedList<>();
        // Add the left and right children of the root to the queue
        q.offer(root.left);
        q.offer(root.right);
    

        while(!q.isEmpty()){
            // Extract nodes in pairs representing corresponding nodes from left and right subtrees
            TreeNode leftNode = q.poll();
            TreeNode rightNode = q.poll();
    
            // If both nodes are null, continue to the next pair
            if(leftNode == null && rightNode == null) continue;
            // If one of the nodes is null and the other isn't, the tree is not symmetric
            if(leftNode == null || rightNode == null) return false;
            // If values of corresponding nodes don't match, the tree is not symmetric
            if(leftNode.val != rightNode.val) return false;
    
            // Add the left child of left subtree and right child of right subtree to the queue
            q.offer(leftNode.left);
            q.offer(rightNode.right);
            // Add the right child of left subtree and left child of right subtree to the queue
            q.offer(leftNode.right);
            q.offer(rightNode.left);
        }
        // If the loop completes without finding any asymmetry, the tree is symmetric
        return true;
    }

}
