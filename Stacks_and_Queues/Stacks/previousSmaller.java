import java.util.*;

public class previousSmaller {
    
    public static int[] findPreviousSmaller(int[]arr){
        int n = arr.length;
        Stack<Integer>st = new Stack<>();
        int[]res = new int[n];

        st.push(0);
        res[0] = -1;

        for(int i = 1; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            if(st.isEmpty()) res[i] = -1;
            else res[i] = st.peek();
        }
        return res;
    }

}
