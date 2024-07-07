import java.util.*;

public class nextGreater_II {
    
    public static int[]nge_II(int[]nums){


        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];


        for (int i = (2 * n) - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i % n]) {
                st.pop();
            }
        // If the current index is within the original array bounds
            if (i < n) {
                res[i] = (st.isEmpty()) ? -1 : st.peek();
            }
            st.push(nums[i % n]);
        }
        return res;

    }

    

}
