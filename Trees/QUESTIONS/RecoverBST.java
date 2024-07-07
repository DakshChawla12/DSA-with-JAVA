
public class RecoverBST {

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

    private TreeNode prev;
    private TreeNode first;
    private TreeNode mid;
    private TreeNode last;

    public void InOrder(TreeNode root){ 
        
        if(root == null) return;

        InOrder(root.left);

        if(prev != null && (root.val < prev.val)){

            if(first == null){ // if this is first violation mark these two nodes
                first = prev;
                mid = root;
            }
            else{ // if this is second violation mark the last node
                last = root;
            }
        }
        // mark the current node as previous
        prev = root;
        InOrder(root.right);
    }
    public void recoverTree(TreeNode root) {
        first = mid = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);

        InOrder(root);

        if(first != null && last != null){
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        else if(first != null && mid != null){
            int temp = first.val;
            first.val = mid.val;
            mid.val = temp;
        }
    }

}
