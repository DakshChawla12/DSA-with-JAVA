import java.util.*;

public class TopView {
    
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

    class pair{
        int line;
        TreeNode node;
        pair(TreeNode node , int x){
            this.node = node;
            this.line = x;
        }
    }

    public ArrayList<Integer> topView(TreeNode root) {
        
        ArrayList<Integer>ans = new ArrayList<>();
        if(root == null) return ans;
        
        Map<Integer,Integer>map = new TreeMap<>();
        
        Queue<pair>q = new LinkedList<pair>();
        q.add(new pair(root,0));
        
        while(!q.isEmpty()){
            
            pair it = q.remove();
            int verticalIdx = it.line;
            TreeNode temp = it.node;
            
            if(map.get(verticalIdx) == null) map.put(verticalIdx,temp.val);
            if(temp.left != null) q.add(new pair(temp.left,verticalIdx-1));
            if(temp.right != null) q.add(new pair(temp.right,verticalIdx+1));
        }
        
        for(Map.Entry<Integer,Integer>entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }

}
