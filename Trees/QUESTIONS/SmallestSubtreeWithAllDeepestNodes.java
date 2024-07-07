package QUESTIONS;
import java.util.*;
public class SmallestSubtreeWithAllDeepestNodes {

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

    public void parentMapping(TreeNode root , HashMap<TreeNode,TreeNode>mpp){
        Queue<TreeNode>q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left != null){
                mpp.put(node.left, node);
                q.offer(node.left);
            }
            if(node.right != null){
                mpp.put(node.right, node);
                q.offer(node.right);
            }
        }
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {

        if(root.left == null && root.right == null) return root;

        HashMap<TreeNode,TreeNode>mpp = new HashMap<>();
        parentMapping(root,mpp);

        Set<TreeNode> deepestNodes = new HashSet<>();
        Queue<TreeNode>q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){

            int size = q.size();
            deepestNodes.clear();

            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                deepestNodes.add(curr);
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
        }

        while (deepestNodes.size() > 1) {
            Set<TreeNode> parents = new HashSet<>();
            for (TreeNode node : deepestNodes) {
                parents.add(mpp.get(node));
            }
            deepestNodes = parents;
        }
        return deepestNodes.iterator().next();
    }
}
