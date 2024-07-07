// 2nd approach
import java.util.*;

public class nextGreaterElement_II {
    
    public static int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];

        st.push(0);

        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                int index = st.pop();
                res[index] = arr[i];
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            int index = st.pop();
            res[index] = -1;
        }

        return res;
    }

    public static void main(String[] args) {
        int[]arr = {2,3,2,4,5,1,7,8};
        int[]res = nextGreaterElements(arr);

        for(int i = 0; i < res.length; i++){
            System.out.println(arr[i] + " ||" + res[i]);
        }
    }

}
