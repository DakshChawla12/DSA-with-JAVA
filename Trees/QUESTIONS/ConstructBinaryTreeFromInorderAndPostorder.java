import java.util.*;

public class ConstructBinaryTreeFromInorderAndPostorder {
    
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

    public TreeNode build_tree(int[]postorder,int postStart,int postEnd,int[]inOrder,int inStart,int inEnd,Map<Integer,Integer>map){

        if(postEnd < postStart || inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        
        int rootIdx = map.get(root.val);
        int numsLeft = rootIdx-inStart;

        root.left = build_tree(postorder,postStart,postStart+numsLeft-1,inOrder,inStart,rootIdx-1,map);
        root.right = build_tree(postorder, postStart+numsLeft, postEnd-1, inOrder, rootIdx+1, inEnd, map);

        return root;

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder == null || postorder == null || inorder.length != postorder.length) return null;

        Map<Integer,Integer>map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        TreeNode root = build_tree(postorder,0,postorder.length-1,inorder,0,inorder.length-1,map);
        
        return root;
    }

}
