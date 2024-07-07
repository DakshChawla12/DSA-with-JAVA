package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class permutations {
    // approach - 1
    public static void helper(int[] nums, List<Integer> ds, boolean[] isValid, List<List<Integer>> ans) {
    // Base case: if the current permutation is of the same length as the input array
        if (ds.size() == nums.length) {
        ans.add(new ArrayList<>(ds));
    }

        for (int i = 0; i < nums.length; i++) {
        // Check if the current element has not been used in the current permutation
            if (!isValid[i]) {
            // Include the current element in the permutation
                ds.add(nums[i]);
                isValid[i] = true;
            // Recursive call to generate permutations with the updated state
                helper(nums, ds, isValid, ans);

            // Backtrack: undo the inclusion of the current element for the next iteration
                isValid[i] = false;
                ds.remove(ds.size() - 1);  // Remove the last element to backtrack
        }
    }
}

    public static List<List<Integer>> permute(int[] nums) {
    // Initialize the result list to store all permutations
        List<List<Integer>> ans = new ArrayList<>();
    
    // Initialize a list to store the current permutation
        List<Integer> ds = new ArrayList<>();
    
    // Initialize a boolean array to track which elements have been used in the current permutation
        boolean[] isValid = new boolean[nums.length];
    
    // Start the permutation generation process
        helper(nums, ds, isValid, ans);
    
    // Return the final list of permutations
    return ans;
}

    // approach - 2
    public static void helper_II(int[]arr , int idx , List<List<Integer>>res){

        if(idx == arr.length){
            List<Integer>ds = new ArrayList<>();
            for(int i = 0; i < arr.length; i++){
                ds.add(arr[i]);
            }
            res.add(ds);
            return;
        }
        for(int i = idx; i < arr.length; i++){
            swap(i, idx, arr);
            helper_II(arr, idx+1, res);
            swap(i, idx, arr);
        }
    }

    public static void swap(int i , int j , int[]arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[]nums = {1,2,3};
        List<List<Integer>>ls = permute(nums);
        System.out.println(ls);
    }

}
