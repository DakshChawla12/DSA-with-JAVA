import java.util.*;

public class stockSpan {
    
    public static int[]Stock_SPan(int[]arr){
        int n = arr.length;
        Stack<Integer>st = new Stack<>();
        int[]res = new int[n];

        res[0] = 1;
        st.push(0);

        for(int i = 1; i < n; i++){
            //we pop elements from the stack till price at top of stack 
            //is less than or equal to current price.
            while(!st.isEmpty() && arr[st.peek()] < arr[i]){
                st.pop();
            }
            //if stack becomes empty, then price[i] is greater than all 
            //elements on left of it in list so span is i+1.
            //Else price[i] is greater than elements after value at top of stack.
            if(st.isEmpty()) res[i] = i+1;
            else res[i] = i-st.peek();
            st.push(i);
        }
        return res;
    }
    public static void main(String[] args) {
        int[]arr = {100,80,60,70,60,75,85};
        int[]res = Stock_SPan(arr);

        for(int i = 0; i < res.length; i++){
            System.out.print(res[i]+" ");
        }
    }

}