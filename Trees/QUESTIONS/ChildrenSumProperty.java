
public class ChildrenSumProperty {

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

    public void childrenSum(TreeNode root){

    // Base case: If the current node is null, return
    if(root == null) return;
    
    // Calculate the sum of values of left and right child nodes
    int child = 0;
    if(root.left != null) child += root.left.val;
    if(root.right != null) child += root.right.val;

    // If the sum of child values is greater than or equal to the current node value,
    // update the current node value with the sum
    if(child >= root.val){
        root.val = child;
    }
    // If the sum of child values is less than the current node value,
    // distribute the current node value equally among its children
    else{
        if(root.left != null) root.left.val = root.val;
        if(root.right != null) root.right.val = root.val;
    }

    // Recursively call the function for left and right subtrees
    childrenSum(root.left);
    childrenSum(root.right);

    // Calculate the total sum of values of left and right child nodes
    int total = 0;
    if(root.left != null) total += root.left.val;
    if(root.right != null) total += root.right.val;
    if(root.left != null || root.right != null) root.val = total; // only update the values when it is not a leaf node
    }

}
