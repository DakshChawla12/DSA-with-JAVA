import java.util.ArrayList;
import java.util.List;

public class PathSumExistsAtAnyNode {
    
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

    public void helper(TreeNode node , int sum , List<Integer>path , List<List<Integer>>paths){
        if(node == null) return;
        path.add(node.val);
        if(node.val == sum && node.left == null && node.right == null){
            paths.add(new ArrayList<>(path));
        }else{
            helper(node.left, sum-node.val, path, paths);
            helper(node.right, sum-node.val, path, paths);
        }
        path.remove(path.size()-1);
    }

    public List<List<Integer>> getPaths(TreeNode root , int sum){
        List<Integer>path = new ArrayList<>();
        List<List<Integer>>paths = new ArrayList<>();
        helper(root, sum, path, paths);
        return paths;
    }

}
