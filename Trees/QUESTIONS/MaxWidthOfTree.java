import java.util.*;

public class MaxWidthOfTree {
    
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

    class Pair{
        TreeNode node; 
        int num; 
        Pair(TreeNode _node, int _num) {
            num = _num;
            node = _node; 
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        if(root == null) return 0;
        
        int ans = 0;
        
        Queue<Pair> q = new LinkedList<>();
        // Start with root at index 0
        q.offer(new Pair(root,0));
    
        while(!q.isEmpty()){
            // Number of nodes at this level
            int levelSize = q.size();
            // Index of the first node at this level
            int mini = q.peek().num;
            // Index of the first and last nodes at this level
            int first = 0 , last = 0;
    
            for(int i = 0; i < levelSize; i++){
                // Index of the current node relative to the leftmost node at this level
                int currIdx = q.peek().num - mini;
                TreeNode curr = q.peek().node;
                q.poll();
                // Update first and last index if necessary
                if(i == 0) first = currIdx;
                if(i == levelSize - 1) last = currIdx;
    
                if(curr.left != null){
                    q.offer(new Pair(curr.left , currIdx*2+1));
                }
                if(curr.right != null){
                    q.offer(new Pair(curr.right , currIdx*2+2));
                }
            }
            ans = Math.max(ans,(last-first)+1);
        }
        return ans;
    }
    

}
