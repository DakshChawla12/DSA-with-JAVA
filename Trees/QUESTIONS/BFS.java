package QUESTIONS;

import java.util.*;

public class BFS {
    
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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>>res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode>q = new LinkedList<>();
        q.offer(root);  // Add the root node to the queue to start traversal

        while(!q.isEmpty()){ // Perform level order traversal
            int levelSize = q.size();  // Determine the number of nodes at the current level
            List<Integer>ans = new ArrayList<>(levelSize);

            for(int i = 0; i < levelSize; i++){
                TreeNode curr = q.poll(); // Dequeue the current node from the queue
                ans.add(curr.val);
                if(curr.left != null) q.offer(curr.left);  // Enqueue the left child if exists
                if(curr.right != null) q.offer(curr.right);  // Enqueue the right child if exists
            }
            res.add(ans);
        }
        return res;
    }
    
}
