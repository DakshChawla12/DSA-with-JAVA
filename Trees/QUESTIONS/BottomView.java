import java.util.*;

public class BottomView {
    
    public class TreeNode {
        int val;
        int verticalIdx;
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

    public List<Integer>bottomView(TreeNode root){

        List<Integer>ans = new ArrayList<>();
        if(root == null) return ans;

        Map<Integer,Integer>map = new TreeMap<>();

        Queue<TreeNode>q = new LinkedList<>();
        root.verticalIdx = 0;
        q.add(root);

        while(!q.isEmpty()){
            TreeNode temp = q.remove();
            int hd = temp.verticalIdx; // horizontal distance
            
            map.put(hd, temp.val);

            if(temp.left != null){
                temp.left.verticalIdx = hd-1;
                q.add(temp.left);
            }
            if(temp.right != null){
                temp.right.verticalIdx = hd+1;
                q.add(temp.right);
            }
        }

        for(Map.Entry<Integer,Integer>entry : map.entrySet()){
            ans.add(entry.getValue());
        }

        return ans;

    }

}
