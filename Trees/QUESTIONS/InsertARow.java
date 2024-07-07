package QUESTIONS;
import java.util.*;
public class InsertARow {

    public static class TreeNode {
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


    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        if(depth == 1){
            TreeNode res = new TreeNode(val);
            res.left = root;
            return res;
        }

        TreeNode curr = root;
        Queue<TreeNode>q = new LinkedList<>();
        int c = 1;
        q.offer(curr);

        while(c < depth-1){
            int size = q.size();
            int k = 0;
            while(k < size){
                TreeNode temp = q.poll();
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
                k++;
            }
            c++;
        }
        while(!q.isEmpty()){
            TreeNode t = q.poll();
            TreeNode l = t.left;
            TreeNode r = t.right;
            t.left = new TreeNode(val);
            t.right = new TreeNode(val);
            t.left.left = l;
            t.right.right = r;
        }
        return root;
    }
}
