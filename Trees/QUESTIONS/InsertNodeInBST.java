
public class InsertNodeInBST {

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

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if(root == null){
            return new TreeNode(val);
        }
        TreeNode curr = root;
        while(true){
            if(curr.val < val){
                if(curr.right != null) curr = curr.right;
                else{
                    TreeNode res = new TreeNode(val);
                    curr.right = res;
                    break;
                }
            }
            else{
                if(curr.left != null) curr = curr.left;
                else{
                    TreeNode res = new TreeNode(val);
                    curr.left = res;
                    break;
                }
            }
        }
        return root;
    }

}
