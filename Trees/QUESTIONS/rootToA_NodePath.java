import java.util.*;

public class rootToA_NodePath {
    
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

    public static boolean getPaths(TreeNode node , List<Integer>res , int x){
        if(node == null) return false;
        res.add(node.val);
        if(node.val == x) return true;
        if((getPaths(node.left, res, x)) || getPaths(node.right, res, x)){
            return true;
        }
        res.remove(res.size()-1);
        return false;
    }
    public static List<Integer> helper(TreeNode root , int x){
        List<Integer>res = new ArrayList<>();
        if(root == null) return res;
        getPaths(root, res, x);
        return res;
    }
}
