import java.util.*;

public class IterativePreorder {
    
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

    public static List<Integer> preOrder(TreeNode root){
        List<Integer>res = new ArrayList<>();
        Stack<TreeNode>st = new Stack<>();
        if(root != null) st.push(root);

        while(!st.isEmpty()){
            TreeNode curr = st.peek();
            res.add(curr.val);
            st.pop();
            if(curr.right != null) st.push(curr.right);
            if(curr.left != null) st.push(curr.left);
        }
        return res;
    }
    public static List<Integer> helper(TreeNode root){
        List<Integer>res = preOrder(root);
        return res;
    }

}


