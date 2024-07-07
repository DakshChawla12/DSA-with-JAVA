import java.util.*;

public class remove_Consecutive_Subsequences {
    
    public static int[] removesubs(int[]arr){
        int n = arr.length;
        Stack<Integer>st = new Stack<>();

        for(int i = 0; i < n; i++){
            if(st.size() == 0 || st.peek() != arr[i]){
                st.push(arr[i]);
            }
            else if(st.peek() == arr[i]){
                if(i == n-1 || arr[i] != arr[i+1]){
                    st.pop();
                }
            }
        }
        int[]res = new int[st.size()];
        for(int i = st.size()-1; i >= 0; i--){
            res[i] = st.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        int[]arr = new int[]{1,2,2,2,3,4,4,5,6,6,7};
        int[]res = removesubs(arr);
        for(int i = 0; i < res.length; i++){
            System.out.print(res[i]+" ");
        }
    }

}
