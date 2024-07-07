import java.util.*;

public class IterativeInorder {
    
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

    public static List<Integer>Iterative_Inorder(TreeNode root){
        List<Integer>res = new ArrayList<>();
        Stack<TreeNode>st = new Stack<>();
        TreeNode node = root;

        while(true){
            if(node != null){
                st.push(node);
                node = node.left;
            }
            else{
                if(st.isEmpty()) break;
                else{
                    node = st.pop();
                    res.add(node.val);
                    node = node.right;
                }
            }
        }
        return res;
    }

}
