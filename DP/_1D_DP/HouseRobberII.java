package _1D_DP;

import java.util.*;
public class HouseRobberII {

    public int helperIII(int[] nums) { // *** space-optimised(tabulation)

        int prev = nums[0];
        int prev2 = 0;

        for(int i = 1; i < nums.length; i++){
            int pick = nums[i];
            if(i > 1) pick += prev2;
            int skip = prev;
            int curr = Math.max(pick,skip);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    public int rob(int[] nums) {


        if(nums.length == 0 ) return 0;
        if(nums.length == 1) return nums[0];

        int n = nums.length;
        int includeFirst = helperIII(Arrays.copyOfRange(nums,0,n-1));
        int includeLast = helperIII(Arrays.copyOfRange(nums,1,n));

        return Math.max(includeFirst,includeLast);
    }

}
