import java.util.*;

public class rootToLeafPaths {
    
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

    public static void RootToLeaf(TreeNode node , List<Integer>ds , List<List<Integer>>res){
        if(node == null) return;
        if(node.left == null && node.right == null){
            res.add(new ArrayList<>(ds));
            return;
        }
        ds.add(node.val);
        RootToLeaf(node.left, ds, res);
        RootToLeaf(node.right, ds, res);
        ds.remove(ds.size()-1);
    }

}
