import java.util.*;

public class nextGreaterElement {
    
    public static int[] FindNextGreater(int[]arr){

        int n = arr.length;
        Stack<Integer>st = new Stack<>();
        int[]res = new int[n];

        res[n-1] = -1;
        st.push(arr[n-1]);

        for(int i = n-2; i >= 0; i--){
            int ele = arr[i];
            while(!st.isEmpty() && st.peek() < ele){
                st.pop();
            }
            if(st.isEmpty()){
                res[i] = -1;
            }
            else{
                res[i] = st.peek();
            }
            st.push(ele);
        }
        return res;
    }
    public static void main(String[] args) {
        int[]arr = {1,3,2,1,8,6,3,4};
        int[]res = FindNextGreater(arr);

        for(int i = 0; i < res.length; i++){
            System.out.print(res[i] + " ");
        }
    }

}
