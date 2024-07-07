import java.util.*;

public class BoundaryTraversal {
    
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

    public boolean isLeaf(TreeNode node){
        return (node.left == null) && (node.right == null);
    }
    public void addLeft(TreeNode root , List<Integer>res){
        TreeNode curr = root.left;
        while(curr != null){
            if(isLeaf(curr) == false) res.add(curr.val);
            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }
    public void addRight(TreeNode root , List<Integer>res){
        List<Integer>temp = new ArrayList<>();
        TreeNode curr = root.right;
        while(curr != null){
            if(isLeaf(curr) == false) temp.add(curr.val);
            if(curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        for(int i = temp.size()-1; i >= 0; i--){
            res.add(temp.get(i));
        }
    }
    public void addLeafNodes(TreeNode root , List<Integer>res){
        if(isLeaf(root)){
            res.add(root.val);
            return;
        }
        if(root.left != null) addLeafNodes(root.left, res);
        if(root.right != null) addLeafNodes(root.right, res);
    }
    public void helper(TreeNode root , List<Integer>res){
        addLeft(root, res);
        addLeafNodes(root, res);
        addRight(root, res);
    }

    public static void main(String[] args) {
        BoundaryTraversal boundaryTraversal = new BoundaryTraversal();

        TreeNode root = boundaryTraversal.new TreeNode(1);
        root.left = boundaryTraversal.new TreeNode(2);
        root.right = boundaryTraversal.new TreeNode(3);
        root.left.left = boundaryTraversal.new TreeNode(4);
        root.left.right = boundaryTraversal.new TreeNode(5);
        root.right.left = boundaryTraversal.new TreeNode(6);
        root.right.right = boundaryTraversal.new TreeNode(7);

        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        boundaryTraversal.helper(root, result);

        System.out.println("Boundary Traversal: " + result);
    }

}
