
public class SplitArrayLargestSum {

    public static boolean isPossible(int[]arr , int k , int mid){
        int count = 1 , sum = 0;
        for(int i = 0; i < arr.length; i++){
            if(sum + arr[i] <= mid){
                sum += arr[i];
            }
            else{
                count++;
                if(count > k || arr[i] > mid) return false;
                sum = arr[i];
            }
        }
        return true;
    }

    public static int helper(int[]arr , int k){
        int n = arr.length , sum = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
        }
        int s = 0 , e = sum;
        int mid = s + (e - s)/2;
        int ans = -1;

        while(s <= e){
            if(isPossible(arr , k , mid)){
                ans = mid;
                e = mid - 1;
            }
            else{
                s = mid + 1;
            }
            mid = s + (e - s)/2;
        }
        return ans;
    }

    public static int splitArray(int[] nums, int k) {
        return helper(nums,k);
    }
    public static void main(String[] args) {
        int[]nums = {1,2,3,4,5,6};
        int k = 3;
        System.out.println(splitArray(nums, k));
    }

}
