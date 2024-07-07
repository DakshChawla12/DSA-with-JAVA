import java.util.ArrayList;
import java.util.List;

public class combinationSum_III {
    
    public void helper(int num , int k , int target , List<Integer>ds , List<List<Integer>>res){
        if(ds.size() == k){
            if(target == 0){
                res.add(new ArrayList<>(ds));
            }
            return;
        }
        if(num > 9|| k > target) return;
        ds.add(num);
        helper(num+1,k,target-num,ds,res);
        ds.remove(ds.size()-1);
        helper(num+1,k,target,ds,res);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer>ds = new ArrayList<>();
        List<List<Integer>>res = new ArrayList<>();
        helper(1,k,n,ds,res);
        return res;
    }

}
