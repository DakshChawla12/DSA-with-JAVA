package QUESTIONS;

import java.util.ArrayList;
import java.util.List;

public class Morris_Inorder_and_Preorder {
    
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

    public static List<Integer>MorrisInorder(TreeNode root){
        List<Integer>res = new ArrayList<>();
        TreeNode curr = root;

        while(curr != null){
            
            if(curr.left == null){
                res.add(curr.val);
                curr = curr.right;
            }
            else{
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = curr;
                    curr = curr.left;
                }
                else{
                    prev.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                }
            }

        }
        return res;
    }

    public static List<Integer>MorrisPreorder(TreeNode root){
        List<Integer>res = new ArrayList<>();
        TreeNode curr = root;

        while(curr != null){
            
            if(curr.left == null){
                res.add(curr.val);
                curr = curr.right;
            }
            else{
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = curr;
                    res.add(curr.val);
                    curr = curr.left;
                }
                else{
                    prev.right = null;
                    curr = curr.right;
                }
            }

        }
        return res;
    }

}
