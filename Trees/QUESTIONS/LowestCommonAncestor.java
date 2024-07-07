
public class LowestCommonAncestor {
    
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    // If the root is null, return null because there's no ancestor.
    if(root == null) return null;
    
    // If the root is one of the nodes we're looking for (p or q),
    // it is the lowest common ancestor itself.
    if(root == p || root == q) return root;
    
    // Recursively find the lowest common ancestor in the left subtree.
    TreeNode Left = lowestCommonAncestor(root.left, p, q);
    
    // Recursively find the lowest common ancestor in the right subtree.
    TreeNode Right = lowestCommonAncestor(root.right, p, q);
    
    // If both left and right subtrees have found an ancestor (not null),
    // then the current root is the lowest common ancestor.
    if(Left != null && Right != null) return root;
    
    // If one of the subtrees found an ancestor, return it.
    // If both subtrees didn't find an ancestor (both are null),
    // return either Left or Right (whichever is not null).
    return Left == null ? Right : Left;
}


}
