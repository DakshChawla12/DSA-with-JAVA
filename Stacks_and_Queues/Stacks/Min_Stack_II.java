import java.util.*;      // constant space and constant time

public class Min_Stack_II {
    Stack<Long>st;
    Long min = Long.MAX_VALUE;

    public  Min_Stack_II() {
        st = new Stack<>();
    }
    
    public void push(int val) {

        long x = (long)val;

        if(st.isEmpty()){
            st.push(x);
            min = x;
        }
        else{
            if(x >= min){
                st.push(x);
            }
            else{
                st.push(2*x-min);
                min = x;
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()){
            return;
        }
        else{
            if(st.peek() >= min) st.pop();
            // peek p fake value pdi h
            else if(st.peek() < min){
                // restoring the old value 
                long oldMin = 2*min-st.peek();
                min = oldMin;
                st.pop();
            }
        }
    }
    
    public int top() {
        if(st.isEmpty()) return -1;
        long q = st.peek();
        long p = min;
        if(q >= min) return (int)(q);
        // farzii val ka case
        // if(st.peek() < min) 
        return (int)(p);
    }
    
    public int getMin() {
        if(st.isEmpty()) return -1;
        long q = min;
        return (int)(q);
    }
}
