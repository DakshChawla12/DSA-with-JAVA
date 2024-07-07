public class HouseRobber {

    public static int maxMoney(int[] nums, int n, int index, int amnt) {
        if (index >= n) {
            return amnt;
        }

        // Include the current house and skip the next one
        int includeCurrent = maxMoney(nums, n, index + 2, amnt + nums[index]);

        // Skip the current house and move to the next one
        int skipCurrent = maxMoney(nums, n, index + 1, amnt);

        // Return the maximum of the two options
        return Math.max(includeCurrent, skipCurrent);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 2) return Math.max(nums[0] , nums[1]);
        int res = maxMoney(nums,n,0,0);
        return res;
    }

}
