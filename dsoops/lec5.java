

public class lec5 {
    
    public static int binSearch(int[]arr , int k){ // q1
        int n = arr.length;
        int s = 0 , e = n-1;
        int mid = s + (e - s)/2;

        while(s >= e){
            if(arr[mid] == k){
                return mid;
            }
            else if(k > mid){
                e = mid-1;
            }
            else{
                s = mid+1;
            }
            mid = s + (e - s)/2;
        }
        return -1;
    }

    public static int findMin(int[]arr){

        int n = arr.length;

        int s = 0 , e = n-1;
        int mid = s + (e - s)/2;

        int ans = Integer.MAX_VALUE;
        
        while (s <= e) {
            if(arr[mid] >= arr[s]){
                ans = Math.min(ans,arr[s]);
                s = mid +1;
            }
            else if(arr[mid] <= arr[e]){
                ans = Math.min(ans, arr[mid]);
                e = mid-1;
            }
            mid = s + (e-s)/2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[]arr = new int[]{6,7,8,9,1,2,3,4};
        int ans = findMin(arr);
        System.out.println(ans);

    }

}
