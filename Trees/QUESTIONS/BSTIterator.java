import java.util.Stack;

class BSTIterator {


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


    private Stack<TreeNode> st = new Stack<>(); // Stack to hold nodes
    public BSTIterator(TreeNode root) {
        push(root); // Initialize the stack by pushing nodes in the leftmost path
    }
    
    public int next() {
        TreeNode nxt = st.pop(); // Pop the top node from the stack
        push(nxt.right); // Push the right subtree of the popped node onto the stack
        return nxt.val; // Return the value of the popped node
    }
    
    public boolean hasNext() {
        return !st.isEmpty(); // Check if the stack is not empty
    }

    // Helper method to push nodes onto the stack along the leftmost path
    private void push(TreeNode node) {
        while (node != null) {
            st.push(node);  // Push the current node onto the stack
            node = node.left;  // Move to the left child
        }   
    }
}