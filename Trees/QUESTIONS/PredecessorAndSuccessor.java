import java.util.*;

public class PredecessorAndSuccessor {

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

    public static TreeNode Successor(TreeNode node , int key){
        TreeNode temp = node;
        TreeNode s = null;
        while(temp != null){
            if(temp.val <= key) temp = temp.right;
            else{
                s = temp;
                temp = temp.left;
            }
        }
        return s;
    }
    public static TreeNode Predecessor(TreeNode node , int key){
        TreeNode temp = node;
        TreeNode p = null;
        while(temp != null){
            if(temp.val < key){
                p = temp;
                temp = temp.right;
            } 
            else{
                temp = temp.left;
            }
        }
        return p;
    }

    public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
        TreeNode temp1 = Successor(root,key);
        TreeNode temp2 = Predecessor(root,key);
        List<Integer>res = new ArrayList<>();
        if(temp2 == null){
            res.add(-1);
        }
        else res.add(temp2.val);

        if(temp1 == null){
            res.add(-1);
        }
        else res.add(temp1.val);

        return res;
    }
    
}