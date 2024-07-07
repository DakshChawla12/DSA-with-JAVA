package QUESTIONS;

import java.util.*;

public class ZigZag_levelOrderTraversal {
    
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>>res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode>q = new LinkedList<>();
        boolean rev = false;
        q.offer(root);  
        while(!q.isEmpty()){ 
            int levelSize = q.size(); 
            List<Integer>ans = new ArrayList<>(levelSize);
            if(!rev){
                for(int i = 0; i < levelSize; i++){
                    TreeNode curr = q.pollFirst(); 
                    ans.add(curr.val);
                    if(curr.left != null) q.addLast(curr.left);
                    if(curr.right != null) q.addLast(curr.right);
                }
            }
            else{
                for(int i = 0; i < levelSize; i++){
                    TreeNode curr = q.pollLast(); 
                    ans.add(curr.val);
                    if(curr.right != null) q.addFirst(curr.right);
                    if(curr.left != null) q.addFirst(curr.left);
                }
            }
            rev = !rev;
            res.add(ans);
        }
        return res;
    }

}
