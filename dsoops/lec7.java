public class lec7 {
    
    public static int Find_First_Missing_Positive(int arr[]) {
        int n = arr.length;
    
        int res[] = new int[n + 2];
    
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0 && arr[i] <= n) {
                res[arr[i]]++;
            }
        }
    
        for (int i = 1; i < res.length; i++) {
            if (res[i] == 0) {
                return i;
            }
        }
    
        return n + 1;
    }
    

    public static void main(String[] args) {
        int[]arr = new int[]{1,2,4,5,6};
        int ans = Find_First_Missing_Positive(arr);
        System.out.println(ans);
    }

}
