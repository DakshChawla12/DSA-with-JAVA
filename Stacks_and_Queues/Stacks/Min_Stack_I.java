import java.util.*; // constant time 

public class Min_Stack_I {
    
    Stack<Integer>st;
    Stack<Integer>min;

    public  Min_Stack_I() {
        st = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(val);
            min.push(val);
        }
        else{
            st.push(val);
            min.push(Math.min(val,min.peek()));
        }
    }
    
    public void pop() {
        st.pop();
        min.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min.peek();
    }

}
