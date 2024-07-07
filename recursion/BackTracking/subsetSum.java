package BackTracking;

import java.util.ArrayList;
import java.util.Collections;

public class subsetSum {

    public static void helper(int[]arr , int idx , int sum , ArrayList<Integer>ds , ArrayList<Integer>res){
        if(idx == arr.length){
            res.add(sum);
            return;
        }
        ds.add(arr[idx]);
        helper(arr, idx+1, sum+arr[idx], ds, res);
        ds.removeLast();
        helper(arr, idx+1, sum, ds, res);
    }

    public static void main(String[] args) {
        int[]arr = {5,2,1};
        ArrayList<Integer>ds = new ArrayList<>();
        ArrayList<Integer>res = new ArrayList<>();
        helper(arr, 0, 0, ds, res);
        Collections.sort(res);
        System.out.println(res);
    }

}
