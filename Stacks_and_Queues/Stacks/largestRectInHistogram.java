import java.util.*;

public class largestRectInHistogram {
    
    public static int[] findNextSmaller(int[]arr){
        int n = arr.length;
        Stack<Integer>st = new Stack<>();
        int[]res = new int[n];

        st.push(n-1);
        res[n-1] = n;

        for(int i = n-2; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.isEmpty()) res[i] = n;
            else res[i] = st.peek();

            st.push(i);
        }
        return res;
    }

    public static int[] findPreviousSmaller(int[]arr){
        int n = arr.length;
        Stack<Integer>st = new Stack<>();
        int[]res = new int[n];

        st.push(0);
        res[0] = -1;

        for(int i = 1; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.isEmpty()) res[i] = -1;
            else res[i] = st.peek();

            st.push(i);
        }
        return res;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[]nse =findNextSmaller(heights); // calculate the next smaller elemet for each element
        int[]pse =findPreviousSmaller(heights); // calculate the previous smaller elemet for each element

        int max = -1;

        for(int i = 0; i < n; i++){
            int area = (heights[i] * (nse[i] - pse[i] - 1));
            max = Math.max(max, area);
        }
        return max;
    }
}
