package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsetSum_II {

    class Solution {

    public void helper(int[]arr , int index , List<Integer>ds , List<List<Integer>>ans){

        ans.add(new ArrayList<>(ds));
            
        for(int i = index; i < arr.length; i++){
            if(i != index && arr[i] == arr[i-1]) continue;
            ds.add(arr[i]);
            helper(arr,i+1,ds,ans);
            ds.remove(ds.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer>ds = new ArrayList<>();
        List<List<Integer>>ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums,0,ds,ans);
        return ans;
    }
}

}
