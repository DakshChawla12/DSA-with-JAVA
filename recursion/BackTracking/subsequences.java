package BackTracking;

import java.util.ArrayList;

public class subsequences {

    public static void getSubsequences(int index , int[]arr , ArrayList<Integer>ds , ArrayList<ArrayList<Integer>>res){
        
        if(index == arr.length){
            res.add(new ArrayList<>(ds));
            return;
        }

        // pick the current element
        ds.add(arr[index]);
        getSubsequences(index+1, arr, ds, res);
        ds.removeLast();
        // not picking the current element
        getSubsequences(index+1, arr, ds, res);
    }

    public static void main(String[] args) {
        int[]arr = {3,1,2};
        ArrayList<Integer>ds = new ArrayList<>();
        ArrayList<ArrayList<Integer>>res = new ArrayList<>();
        getSubsequences(0, arr, ds, res);
        System.out.println(res);
    }

}
