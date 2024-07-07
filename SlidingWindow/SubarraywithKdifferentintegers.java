import java.util.*;
public class SubarraywithKdifferentintegers {

    public static int helper(int[]nums , int k){

        int n = nums.length;
        int l = 0 , r = 0 , cnt = 0;
        HashMap<Integer,Integer>mpp = new HashMap<>();

        while(r < n){
            int num = nums[r];
            mpp.put(num,mpp.getOrDefault(num,0)+1);

            while(mpp.size() > k){
                mpp.put(nums[l], mpp.get(nums[l]) - 1);
                if(mpp.get(nums[l]) == 0){
                    mpp.remove(nums[l]);
                }
                l++;
            }
            if(mpp.size() <= k){
                cnt += r-l+1;
            }
            r++;
        }
        return cnt;
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums,k) - helper(nums,k-1);
    }
    public static void main(String[] args) {
        // [1,2,1,2,3], k = 2
        int[]arr = {1,2,1,3,4};
        System.out.println(subarraysWithKDistinct(arr,3));
    }

}
