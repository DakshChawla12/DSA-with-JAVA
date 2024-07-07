import java.util.*;

public class nextSmaller {
    
    // next smaller k liye right to left travel krna h
    public static int[] findNextSmaller(int[]arr){
        int n = arr.length;
        Stack<Integer>st = new Stack<>();
        int[]res = new int[n];

        st.push(n-1);
        res[n-1] = -1;

        for(int i = n-2; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            if(st.isEmpty()) res[i] = n;
            else res[i] = st.peek();
        }
        return res;
    }

}
