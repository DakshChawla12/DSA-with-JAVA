import java.util.*;

public class reverse_Ist_K {
    
    public static void revvQueue_K(Queue<Integer> q, int k) {
        int size = q.size();
        
        // Validate if k is within the valid range
        if (k > size || k <= 0) {
            System.out.println("Invalid value of k.");
            return;
        }
    
        Stack<Integer> st = new Stack<>();
    
        // Push the first k elements into the stack
        for (int i = 0; i < k; i++) {
            st.push(q.poll());
        }
    
        // Add the elements from the stack back to the queue
        while (!st.isEmpty()) {
            q.offer(st.pop());
        }
    
        // Move the remaining elements to the end of the queue
        for (int i = 0; i < size - k; i++) {
            q.offer(q.poll());
        }
    }
    
    public static void main(String[] args) {
        Queue<Integer>q = new LinkedList<>();
        for(int i = 1; i <= 5; i++){
            q.add(i);
        }
        System.out.println(q);
        revvQueue_K(q,4);
        System.out.println(q);
    }

}
