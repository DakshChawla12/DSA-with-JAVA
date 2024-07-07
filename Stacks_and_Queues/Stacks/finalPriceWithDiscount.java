import java.util.*;

public class finalPriceWithDiscount {
    
        public static int[] finalPrices(int[] prices) {
        int n = prices.length;
        Stack<Integer>st = new Stack<>();
        int[]res = new int[n];

        st.push(n-1);
        res[n-1] = prices[n-1];

        for(int i = n-2; i >= 0; i--){
            while(!st.isEmpty() && prices[i] < prices[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i] = prices[i];
            }
            else{
                res[i] = prices[i]-prices[st.peek()];
            }
            st.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        
        // int[]arr = {10,1,1,6};
        // int[]res = finalPrices(arr);
        // for(int i = 0; i < res.length; i++){
        //     System.out.print(res[i] + " ");
        // }
        System.out.println((int)'a' +" " +  (int)'z');
        System.out.println((int)'a' - (int)'A');

    }

}
