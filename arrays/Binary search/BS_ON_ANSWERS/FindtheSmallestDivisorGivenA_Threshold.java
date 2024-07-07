public class FindtheSmallestDivisorGivenA_Threshold {
    
    public static boolean isPossible(int[]arr, int threshold, int mid){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += Math.ceil((double)(arr[i]) / (double)(mid));
        }
        return sum <= threshold;
    }

    public static int helper(int[]arr , int threshold){
        int n = arr.length;
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            maxi = Math.max(maxi,arr[i]);
        }
        int s = 1 , e = maxi;
        int mid = s + (e - s)/2;
        int ans = -1;

        while(s <= e){
            if(isPossible(arr,threshold,mid)){
                ans = mid;
                e = mid-1;
            }
            else{
                s = mid+1;
            }
            mid = s + (e - s)/2;
        }
        return ans;
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        return helper(nums,threshold);
    }
    public static void main(String[] args) {
        int[]arr = {1,2,3,4,5};
        int threshold = 8;
        System.out.println(smallestDivisor(arr,threshold));
    }

}
