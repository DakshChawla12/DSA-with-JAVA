

public class maxSubarrayProduct {
    
    public static int maxProd(int[] nums) {
        int n = nums.length;
        int maxi = Integer.MIN_VALUE;
        
        int pref = 1, suff = 1; // Initialize prefix and suffix products as 1
    
        for (int i = 0; i < n; i++) {

            if (pref == 0) pref = 1; // Reset prefix product to 1 if it becomes 0 because if we encounter 0 prod will become 0 and we have to start from a new part of array
            if (suff == 0) suff = 1; // Reset suffix product to 1 if it becomes 0
    
            pref *= nums[i]; // Update prefix product by multiplying with the current element
            suff *= nums[n - i - 1]; // Update suffix product by multiplying with the element from the end of the array
    
            maxi = Math.max(maxi, Math.max(pref, suff)); // Update the maximum product considering prefix, suffix, and current maximum
        }
    
        return maxi; 
    }
    

}
