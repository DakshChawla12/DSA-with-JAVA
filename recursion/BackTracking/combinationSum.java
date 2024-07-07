package BackTracking;

import java.util.ArrayList;

public class combinationSum {

    public static void findCombination(int index , int target , int[]arr , ArrayList<Integer>ds , ArrayList<ArrayList<Integer>>res){

        if(index == arr.length){
            if(target == 0){
                res.add(new ArrayList<>(ds));
            }
            return;
        }

        if(arr[index] <= target){
            ds.add(arr[index]);
            findCombination(index, target-arr[index], arr, ds, res);
            ds.removeLast();
        }
        findCombination(index+1, target, arr, ds, res);

    }

    public static void main(String[] args) {
        int[]arr = {2,3,6,7};
        ArrayList<Integer>ds = new ArrayList<>();
        ArrayList<ArrayList<Integer>>res = new ArrayList<>();
        findCombination(0, 7, arr, ds, res);
        System.out.println(res);
    }

}