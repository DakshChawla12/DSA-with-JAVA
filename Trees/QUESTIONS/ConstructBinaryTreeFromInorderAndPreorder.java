import java.util.*;

public class ConstructBinaryTreeFromInorderAndPreorder {
    
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

    public TreeNode build_tree(int[]preOrder, int preStart, int preEnd, int[]inOrder, int inStart, int inEnd, Map<Integer,Integer>map){

        if(preStart > preEnd || inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode(preOrder[preStart]);
        
        int rootIdx = map.get(root.val);
        int numsLeft = rootIdx-inStart;

        root.left = build_tree(preOrder,preStart+1,preStart+numsLeft,inOrder,inStart,rootIdx-1,map);
        root.right = build_tree(preOrder, preStart+numsLeft+1, preEnd, inOrder, rootIdx+1, inEnd, map);

        return root;

    }

    public TreeNode buildTree(int[]preOrder , int[]inOrder){

        Map<Integer,Integer>map = new HashMap<>();
        for(int i = 0; i < inOrder.length; i++){
            map.put(inOrder[i], i);
        }

        TreeNode root = build_tree(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1,map);
        
        return root;
    }

}
