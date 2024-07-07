
public class checkIfPathExists {
    
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

    public boolean checkPath(TreeNode node , int[]arr , int idx){
        if(node == null) return false;
        if(idx >= arr.length || node.val != arr[idx]) return false;
        if(node.left == null && node.right == null && idx == arr.length-1) return true;
        return checkPath(node.left,arr,idx+1) ||checkPath(node.right, arr, idx+1);
    }

}
