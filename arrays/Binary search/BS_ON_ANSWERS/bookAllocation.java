
public class bookAllocation {

    public static boolean isPossible(int[]arr , int n, int m, int mid){
        int studentCount = 1;
        int pgSum = 0;

        for(int i = 0; i < n; i++){
            if(pgSum + arr[i] <= mid){
                pgSum += arr[i];
            }
            else{
                studentCount++;
                if(studentCount > m || arr[i] > mid){
                    return false;
                }
                pgSum = arr[i];
            }
        }
        return true;
    }

    public static int helper(int[]arr , int m){
        int sum = 0;
        int n = arr.length;

        for(int i = 0; i < n; i++){
            sum += arr[i];
        }
        int s = 0;
        int e = sum;

        int mid = s + (e-s)/2;
        int ans = -1;

        while(s <= e){
            if(isPossible(arr, n, m, mid)){ // left part m jaate h kyunki minimum sol chaiye
                ans = mid;
                e = mid-1;
            }
            else{
                s = mid+1;
            }
            mid = s + (e-s)/2;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[]arr = {10,20,30,40};
        int m = 2;
        int res = helper(arr, m);
        System.out.println(res);
    }
    
}