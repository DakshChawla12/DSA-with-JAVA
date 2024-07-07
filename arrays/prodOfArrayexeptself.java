

public class prodOfArrayexeptself {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[]arr = new int[n];
        
        for(int i = 0; i < n; i++){
            int j = n-1;
            int prod = 1;

            while(j >= 0){
                if(j == i){
                    j--;
                    continue;
                }
                prod *= nums[j];
                j--;
            }
            arr[i] = prod;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[]arr = new int[]{1,2,3,4};
        int[]res = productExceptSelf(arr);

        for(int i = 0; i < res.length; i++){
            System.out.print(res[i]+" ");
        }
    }

}