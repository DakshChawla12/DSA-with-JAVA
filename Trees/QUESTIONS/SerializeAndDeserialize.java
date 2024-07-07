import java.util.*;

public class SerializeAndDeserialize {
    
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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode>q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode curr = q.poll();

            if(curr == null){
                sb.append("n ");
                continue;
            }
            sb.append(curr.val+" ");
            q.offer(curr.left);
            q.offer(curr.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        Queue<TreeNode>q = new LinkedList<>();
        String[]val = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(val[0]));
        q.offer(root);

        for(int i = 1; i < val.length; i++){
            TreeNode curr = q.poll();
            if(!val[i].equals("n")){
                TreeNode Left = new TreeNode(Integer.parseInt(val[i]));
                curr.left = Left;
                q.offer(Left);
            }
            if(!val[++i].equals("n")){
                TreeNode Right = new TreeNode(Integer.parseInt(val[i]));
                curr.right = Right;
                q.offer(Right);
            }
        }
        return root;
    }

}
