
public class leastShipCapacity {
    
    public static boolean isPossible(int[]arr , int d , int mid){
        int daysCount = 1;
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            if(sum + arr[i] <= mid){
                sum += arr[i];
            }
            else if (arr[i] > mid) {
                return false;
            }
            else{
                daysCount++;
                if(daysCount > d) return false;
                sum = arr[i];
            }
        }
        return true;
    }

    public static int helper(int[]arr, int d){
        int n = arr.length;
        int sum = 0 , maxi = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            sum += arr[i];
            maxi = Math.max(maxi,arr[i]);
        }
        int s = maxi , e = sum;
        int mid = s + (e - s)/2;
        int ans = -1;
        while(s <= e){
            if(isPossible(arr,d,mid)){
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

    public static int shipWithinDays(int[] weights, int days) {
        return helper(weights,days);
    }

    public static void main(String[] args) {
        int[]weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(shipWithinDays(weights, days));
    }

}
