
public class CheckCousins {
    
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

    public TreeNode findNode(TreeNode node , int x){
        if(node == null) return null;
        if(node.val == x) return node;
        TreeNode n = findNode(node.left,x);
        if(n != null) return n;
        return findNode(node.right,x);
    }

    public int getLevel(TreeNode node,TreeNode x,int lev){
        if(node == null) return 0;
        if(node == x) return lev;
        int l = getLevel(node.left,x,lev+1);
        if(l != 0) return l;
        return getLevel(node.right,x,lev+1);
    }

    public boolean isSibling(TreeNode node , TreeNode x , TreeNode y){
        if(node == null) return false;
        return ((node.left == x && node.right == y) || (node.left == y && node.right == x) || isSibling(node.left,x,y) || isSibling(node.right,x,y));
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root,x);
        TreeNode yy = findNode(root,y);
        return (getLevel(root,xx,0) == getLevel(root,yy,0) && !isSibling(root,xx,yy));
    }

}
