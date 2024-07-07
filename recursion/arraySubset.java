import java.util.*;
public class arraySubset {  

    public static void solve(int[] nums, int index, ArrayList<Integer> output, List<List<Integer>> result) {
        // Base case: if the index is equal to the length of the array, add the current subset to the result and return
        if (index == nums.length) {
            result.add(new ArrayList<>(output));
            return;
        }
    
        // Include the current element in the subset and move to the next index
        output.add(nums[index]);
        solve(nums, index + 1, output, result);
    
        // Exclude the current element from the subset and move to the next index
        output.removeLast();
        solve(nums, index + 1, output, result);
    }
    

    public static List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer>output = new  ArrayList<>();
        List<List<Integer>>result = new ArrayList<>();
        solve(nums , 0 , output , result);
        return result;
    }

    public static void main(String[] args) {
        int[]arr = new int[]{1,2,3};
        List<List<Integer>>ls = subsets(arr);
        System.out.println(ls);
    }

}