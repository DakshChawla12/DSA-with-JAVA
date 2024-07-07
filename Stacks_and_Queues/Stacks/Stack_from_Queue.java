import java.util.*;

class Stack_from_Queue {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public Stack_from_Queue() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
        if (q1.isEmpty()) {
            
            return -1;
        }
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        int removed = q1.poll();
        swapQueues();
        return removed;
    }
    
    public int top() {
        if (q1.isEmpty()) {
            // Stack is empty, return a sentinel value (e.g., -1)
            return -1;
        }
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        int top = q1.poll();
        q2.add(top);
        swapQueues();
        return top;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
    private void swapQueues() {
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
}

