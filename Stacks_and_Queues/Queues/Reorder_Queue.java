import java.util.*;

/*
You are given a queue Q of N integers of even length
rearrange the elements by interleaving the first half of the queue with the second half of the queue.
 */

/*
Steps -->
1) Move first half into stack.
2) Now the add the items from stack into the Queue till size of stack > 0   (after this the elements in 1st half of Queue will be present in the 2nd half of Queue in reverse order)
    eg --> input --> [1,2,3,4,5,6,7,8]  
        queue after 2nd step --> [5,6,7,8,4,3,2,1]
3) Again move the 1st half(2nd half in input Queue [5,6,7,8]) into the stack
4) one by one add Stack.peek() and queue.peek() to the Queue
5) Now reverse the Queue with the help of the stack
*/

public class Reorder_Queue {
    
    public static void ReorderQueue_usingStack(Queue<Integer>q){
        // rn eg Queue is [1,2,3,4,5,6,7,8]

        int n = q.size();
        Stack<Integer>st = new Stack<>();

        for(int i = 1; i <= (n/2); i++){
            st.push(q.remove());
        } // now Queue is [5,6,7,8]  Stack is [4,3,2,1]
        
        while(!st.isEmpty()){
            q.add(st.pop());
        } // now Queue is [5,6,7,8,4,3,2,1]  Stack is []  (empty stack)
    
        for(int i = 1; i <= (n/2); i++){
            st.push(q.remove());
        }// now Queue is [4,3,2,1]  Stack is [8,7,6,5]

        while(!st.isEmpty()){
            // one by one , phle stack se fir Queue se
            
            q.add(st.pop()); // stack ka top element Queue may daal re h
            q.add(q.remove()); // Queue k front element ko peeche push krr re h
        } // now Queue is [1,5,2,6,3,7,4,8] Stack is []  (empty stack)

        // reversing the Queue
        while(n > 0){
            st.push(q.remove());
            n--;
        }
        while(st.size() > 0){
            q.add(st.pop());
        }

    }

    public static void main(String[] args) {
        Queue<Integer>q = new LinkedList<>();
        for(int i = 1; i <= 8; i++){
            q.add(i);
        }
        System.out.println(q);
        ReorderQueue_usingStack(q);
        System.out.println(q);
    }

}
