
public class Diameter {

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

    int diameter = 0;

    public int height(TreeNode node){
        if(node == null) return 0;
        int Left = height(node.left);
        int Right = height(node.right);

        int dia = Left + Right + 1;
        diameter = Math.max(dia,diameter);

        return Math.max(Left,Right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter - 1;
    }

}
