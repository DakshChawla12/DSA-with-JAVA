import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum_II {

    public void helper(int[]arr , int target , int index , List<Integer>ds , List<List<Integer>>ans){
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = index; i < arr.length; i++){
            if(i > index && arr[i] == arr[i-1]) continue;
            if(arr[i] > target) break;
            ds.add(arr[i]);
            helper(arr,target-arr[i],i+1,ds,ans);
            ds.remove(ds.size()-1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer>ds = new ArrayList<>();
        List<List<Integer>>ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates,target,0,ds,ans);
        return ans;
    }

}
