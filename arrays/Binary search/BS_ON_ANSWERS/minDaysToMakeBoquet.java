
public class minDaysToMakeBoquet {
    
    public static boolean isPossible(int[]arr, int m,  int k, int mid){
        int count = 0;
        int total = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= mid){
                count++;
            }
            else{
                total += (count/k);
                count = 0;
            }
        }
        total += (count/k);
        return total >= m;
    }

    public static int helper(int[]arr , int m, int k){
        int n = arr.length;
    
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            maxi = Math.max(maxi,arr[i]);
            mini = Math.min(mini,arr[i]);
        }
        int s = mini , e = maxi;
        int mid = s + (e - s)/2;
        int ans = -1; 
        while(s <= e){
            if(isPossible(arr, m, k, mid)){
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
    
    public static int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length < m*k) return -1;
        int ans = helper(bloomDay, m, k);
        return ans;
    }   
    public static void main(String[] args) {
        int[]bloomDay = {7,7,7,7,13,11,12,7};
        int m = 2 , k = 3;
        System.out.println(minDays(bloomDay, m, k));
    }

}
