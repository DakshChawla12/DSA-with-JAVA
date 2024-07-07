public class MaximumPointsYouCanObtainfromCards {

    public int maxScore(int[] nums, int k) {
        int n = nums.length;
        int lsum = 0 , rsum = 0;

        for(int i = 0; i < k; i++){
            lsum += nums[i];
        }
        int max = lsum;
        int r = n-1;
        for(int i = k-1; i >= 0; i--){
            lsum -= nums[i];
            rsum += nums[r--];
            max = Math.max(max,lsum+rsum);
        }
        return max;
    }

}
