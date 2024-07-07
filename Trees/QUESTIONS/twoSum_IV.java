import java.util.*;



public class twoSum_IV {

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


    class BSTiterator {
        // Stack to keep track of nodes during iteration
        private Stack<TreeNode> st = new Stack<>();
        // Flag indicating whether iteration is in reverse order
        boolean reverse = true;
    
        // Constructor for BSTiterator
        public BSTiterator(TreeNode node, boolean isReverse) {
            reverse = isReverse;
            // Initialize the iterator by pushing nodes onto the stack
            pushAll(node);
        }
    
        // Method to get the next element in the iteration
        public int next() {
            // Pop the top node from the stack
            TreeNode temp = st.pop();
            // Push all the child nodes based on the iteration direction
            if (reverse == false)
                pushAll(temp.right);
            else
                pushAll(temp.left);
            // Return the value of the popped node
            return temp.val;
        }
        // Method to check if there are more elements in the iteration
        public boolean hasNext() {
            // Check if the stack is empty
            return !st.isEmpty();
        }
    
        // Method to push all the nodes onto the stack based on the iteration direction
        public void pushAll(TreeNode node) {
            // Traverse the tree and push nodes onto the stack
            while (node != null) {
                st.push(node);
                // Move to the next node based on the iteration direction
                if (reverse == true) {
                    node = node.right;
                } else {
                    node = node.left;
                }
            }
        }
    }


    public boolean findTarget(TreeNode root, int k) {
        // Check if the tree is empty
        if (root == null)
            return false;
        
        // Create iterators for traversing the BST from both ends
        BSTiterator l = new BSTiterator(root, false);
        BSTiterator r = new BSTiterator(root, true);

        // Get the first elements from both iterators
        int i = l.next();
        int j = r.next();

        // Iterate until there are elements in both iterators
        while (i < j) {
            // Check if the sum of current elements is equal to k
            if (i + j == k)
                return true;
            // Move to the next element from the iterator with smaller value
            else if (i + j < k)
                i = l.next();
            else
                j = r.next();
        }
        // No pair found that sums up to k
        return false;
    }

}
