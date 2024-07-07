import java.util.*;

public class slidingWindowMaximum {
    
    public static int[]findMax(int[]arr , int k){ // brute force

        int n = arr.length;
        int[]res = new int[n-k+1];
        int idx = 0;

        for(int i = 0; i < n-k+1; i++){
            int maxi = Integer.MIN_VALUE;
            for(int j = i; j < i+k; j++){
                maxi = Math.max(maxi,arr[j]);
            }
            res[idx++] = maxi;
        }
        return res;
    }

    public static int[]findMax_better(int[]arr , int k){ // better approach by using next greater element array
        int n = arr.length;
        int[]res = new int[n-k+1];
        int[]nge = new int[n];
        int idx = 0;

        Stack<Integer>st = new Stack<>();
        st.push(n-1);
        nge[n-1] = n;

        for(int i = n-2; i >= 0; i--){ // calculating nge array
            while(st.size() > 0 && arr[i] > arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) nge[i] = n;
            else nge[i] = st.peek();

            st.push(i);
        }
        int j = 0;
        for(int i = 0; i < n-k+1; i++){
            if(j >= i+k) j = i;
            int max = arr[j];

            while(j < i+k){
                max = arr[j];
                j = nge[j];
            }
            res[idx++] = max;
        }
        return res;
    }

}

