package QUESTIONS;

import java.util.*;

public class PopulatingRightNextPtrs {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    
        public Node() {}
        
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    // brute-force approach
    public Node Connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            Node prev = null; // To track the previous node in the current level

            // Process all nodes at the current level
            for(int i = 0; i < size; i++) {
                Node curr = q.poll();

                // Establish the next pointer of the previous node
                if(prev != null) {
                    prev.next = curr;
                }

                // Update the previous node to the current node
                prev = curr;

                // Enqueue the children of the current node if they exist
                if(curr.left != null) {
                    q.offer(curr.left);
                }
                if(curr.right != null) {
                    q.offer(curr.right);
                }
            }

            // Set the next pointer of the last node in the current level to null
            prev.next = null;
        }

        return root;
    }

    // optimal approach
    public Node connect(Node root) {
        if(root == null) return null;
        Node leftMost = root;
        while(leftMost.left != null){
            Node curr = leftMost;
            while(curr != null){
                curr.left.next = curr.right;
                if(curr.next != null){
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }
}
