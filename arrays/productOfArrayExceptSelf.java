public class productOfArrayExceptSelf{

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[]res = new int[n];

    
        for (int i = 0; i < n; i++) {

            int pre = 0, suff = n - 1;
            int preProd = 1, suffProd = 1;
    
            while (suff > i) {
                suffProd *= nums[suff];
                suff--;
            }
    
            while (pre < i) {
                preProd *= nums[pre];
                pre++;
            }
    
            res[i] = preProd * suffProd;
        }
    
        return res;
    }
    
    public static int[] productExceptSelf__II(int[] nums) {       // optimised
        int n = nums.length;
    
        // Arrays to store prefix and suffix products
        int[] prefixProducts = new int[n];
        int[] suffixProducts = new int[n];
    
        // Initialize prefix products
        int prefixProd = 1;
        for (int i = 0; i < n; i++) {
            prefixProducts[i] = prefixProd;
            prefixProd *= nums[i];
        }
    
        // Initialize suffix products
        int suffixProd = 1;
        for (int i = n - 1; i >= 0; i--) {
            suffixProducts[i] = suffixProd;
            suffixProd *= nums[i];
        }
    
        // Calculate the final result using prefix and suffix products
        for (int i = 0; i < n; i++) {
            nums[i] = prefixProducts[i] * suffixProducts[i];
        }
    
        return nums;
    }
    

    public static void main(String[] args) {
        int[]arr = new int[]{1,2,3,4};
        int[]res = productExceptSelf__II(arr);
        for(int i = 0; i < res.length; i++){
            System.out.print(res[i] + " ");
        }
    }

}
