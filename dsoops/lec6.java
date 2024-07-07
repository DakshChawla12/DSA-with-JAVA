
public class lec6 {

    public static int findMinIndex(int[]arr){    // find min index of even element
        int n = arr.length;
        int s = 0 , e = n-1;
        int mid = s + (e - s)/2;

        int ans = Integer.MAX_VALUE;

        while(s < e){
            if(arr[mid] % 2 == 0){
                ans = Math.min(ans,mid);
                e = mid;
            }
            else{
                s = mid + 1;
            }
            mid = s + (e - s)/2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[]arr = new int[]{1,3,5,7,9,2,4,6,8,10};
        int res = findMinIndex(arr);
        System.out.println(res);
    }
    
}