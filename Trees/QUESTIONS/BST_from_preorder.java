
public class BST_from_preorder {

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

    private TreeNode insert(int value , TreeNode node){
        if(node == null){
            node = new TreeNode(value);
            return node;
        }
        if(value < node.val){
            node.left = insert(value, node.left);
        }
        if(value > node.val){
            node.right = insert(value, node.right);
        }
        return node;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 1; i < preorder.length; i++){
            insert(preorder[i],root);
        }
        return root;
    }

}
