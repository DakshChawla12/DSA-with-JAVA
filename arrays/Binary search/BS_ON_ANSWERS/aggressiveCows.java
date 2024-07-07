import java.util.Arrays;

public class aggressiveCows {
    
    public static boolean isPossible(int[]arr, int k, int mid){
        int cowCount = 1;
        int lastPos = arr[0];

        for(int i = 0; i < arr.length; i++){
            if(arr[i] - lastPos >= mid){
                cowCount++;
                if(cowCount == k) return true;
                lastPos = arr[i];
            }
        }
        return false;
    }

    public static int helper(int[]arr, int k){
        int n = arr.length;
        int s = 0;
        int maxi = -1;
        for(int i = 0; i < n; i++){
            maxi = Math.max(maxi, arr[i]);
        }
        int e = maxi;
        int mid = s + (e-s)/2;
        int ans = -1;

        while(s <= e){
            if(isPossible(arr, k, mid)){
                s = mid + 1;
                ans = mid;
            }
            else{
                e = mid - 1;
            }
            mid = s + (e-s)/2;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[]arr = {4,2,1,3,6};
        Arrays.sort(arr);
        int k = 2;
        System.out.println(helper(arr, k));
    }

}
