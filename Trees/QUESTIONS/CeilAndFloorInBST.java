
public class CeilAndFloorInBST {

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

    public int findCeil(TreeNode root , int target){

        int ceil = -1;

        while(root != null){
            if(root.val == target){
                ceil = root.val;
                break;
            }
            else if(root.val < target){
                root = root.right;
            }
            else{
                ceil = root.val;
                root = root.left;
            }
        }

        return ceil;

    }

    public int findFloor(TreeNode root , int target){

        int floor = -1;

        while(root != null){
            if(root.val == target){
                floor = root.val;
                break;
            }
            else if(root.val < target){
                floor = root.val;
                root = root.right;
            }
            else{
                root = root.left;
            }
        }
        
        return floor;
    }

}
