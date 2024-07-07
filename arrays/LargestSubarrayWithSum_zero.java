import java.util.*;

public class LargestSubarrayWithSum_zero {
    
    public int Largest_subarray(int[]arr){
        int n = arr.length;

        int sum = 0;
        int maxLen = 0;

        HashMap<Integer,Integer>mpp = new HashMap<>();

        for(int i = 0; i < n; i++){
            sum += arr[i];

            if(sum == 0) maxLen = i+1;

            else{
                if(mpp.get(sum) != null){
                    maxLen = Math.max(maxLen, i-mpp.get(sum));
                }
                else{
                    mpp.put(sum , i);
                }
            }
        }
        return maxLen;
    }

}
