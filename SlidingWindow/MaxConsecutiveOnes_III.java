public class MaxConsecutiveOnes_III {

    public int longestOnes(int[] nums, int k) {

        int n = nums.length;
        int maxLen = 0 , l = 0 , r = 0 , zeroCount = 0;
        while(r < n){
            if(nums[r] == 0) zeroCount++;
            while(zeroCount > k){
                if(nums[l] == 0){
                    zeroCount--;
                }
                l++;
            }
            if(zeroCount <= k){
                maxLen = Math.max(maxLen , r-l+1);
            }
            r++;
        }
        return maxLen;
    }

}
