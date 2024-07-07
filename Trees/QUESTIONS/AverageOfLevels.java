package QUESTIONS;

import java.util.*;

public class AverageOfLevels {

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

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double>res = new ArrayList<>();
        Queue<TreeNode>q = new LinkedList<>();
        q.offer(root);  // Add the root node to the queue to start traversal

        while(!q.isEmpty()){ // Perform level order traversal
            int levelSize = q.size();  // Determine the number of nodes at the current level
            double sum = 0;
            for(int i = 0; i < levelSize; i++){
                TreeNode curr = q.poll(); // Dequeue the current node from the queue
                sum += curr.val; // add the value of current node to sum
                if(curr.left != null) q.offer(curr.left);  // Enqueue the left child if exists
                if(curr.right != null) q.offer(curr.right);  // Enqueue the right child if exists
            }
            res.add(sum/levelSize); // add the average of that level to res
        }
        return res;
    }

}
