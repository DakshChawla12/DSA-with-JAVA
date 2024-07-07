
public class InvertBinaryTree {

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

    public TreeNode invert(TreeNode node){
        if(node == null) return null;
        TreeNode Left = invert(node.left);
        TreeNode Right = invert(node.right);
        node.left = Right;
        node.right = Left;
        return node;
    }

    public TreeNode invertTree(TreeNode root) {
        return invert(root);
    }

}
