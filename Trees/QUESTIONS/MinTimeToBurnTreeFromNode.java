import java.util.*;

public class MinTimeToBurnTreeFromNode {
    
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

    public int maxDistance(TreeNode target , HashMap<TreeNode,TreeNode>mpp){
        Queue<TreeNode>q = new LinkedList<>();
        q.offer(target);
        HashMap<TreeNode,Integer>visited = new HashMap<>();
        visited.put(target, 1);
        int maxi = 0;

        while(!q.isEmpty()){
            
            int size = q.size();
            int fl = 0;

            for(int i = 0;i < size; i++){
                TreeNode node = q.poll();

                if(node.left != null && visited.get(node.left) == null){
                    fl = 1;
                    visited.put(node.left, 1);
                    q.offer(node.left);
                }
                if(node.right != null && visited.get(node.right) == null){
                    fl = 1;
                    visited.put(node.right, 1);
                    q.offer(node.right);
                }
                if(mpp.get(node) != null && visited.get(mpp.get(node)) != null){
                    fl = 1;
                    visited.put(mpp.get(node), 1);
                    q.offer(mpp.get(node));
                }
            }
            if(fl == 1) maxi++;
        }
        return maxi;
    }

    public TreeNode bfsToParent(TreeNode root , int start , HashMap<TreeNode,TreeNode>mpp){
        Queue<TreeNode>q = new LinkedList<>();
        q.offer(root);
        TreeNode res = new TreeNode(-1);

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.val == start){
                res = node;
            }
            if(node.left != null){
                mpp.put(node.left, node);
                q.offer(node.left);
            }
            if(node.right != null){
                mpp.put(node.right, node);
                q.offer(node.right);
            }
        }
        return res;
    }

    public int minTime(TreeNode root , int start){
        HashMap<TreeNode,TreeNode>mpp = new HashMap<>();
        TreeNode target = bfsToParent(root,start,mpp);
        return maxDistance(target, mpp);
    }

}
