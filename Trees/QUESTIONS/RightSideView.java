import java.util.*;



public class RightSideView {
    
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode>q = new LinkedList<>();
        q.offer(root);  

        while(!q.isEmpty()){ 
            int levelSize = q.size();  
            for(int i = 0; i < levelSize; i++){
                TreeNode curr = q.poll(); 
                if(i == levelSize-1) res.add(curr.val);
                if(curr.left != null) q.offer(curr.left);  
                if(curr.right != null) q.offer(curr.right); 
            }
        }
        return res;
    }

}
