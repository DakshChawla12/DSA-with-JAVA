import java.util.ArrayList;

public class subsequencesWithSum_K {

    public static void getSUbsequences(int[]arr , int index , int target , int sum , ArrayList<Integer>ds , ArrayList<ArrayList<Integer>>res){
        
        if(index == arr.length){
            if(sum == target){
                res.add(new ArrayList<>(ds));
            }
            return;
        }
        ds.add(arr[index]);
        getSUbsequences(arr, index+1, target, sum+arr[index], ds, res);
        ds.removeLast();
        getSUbsequences(arr, index+1, target, sum, ds, res);
    }

    // modification to get only one subsequence if multiple exists
    public static boolean get_SUbsequences(int[]arr , int index , int target , int sum , ArrayList<Integer>ds , ArrayList<ArrayList<Integer>>res){

        if(index == arr.length){
            if(sum == target){
                res.add(new ArrayList<>(ds));
                return true;
            }
            return false;
        }
        ds.add(arr[index]);
        if(get_SUbsequences(arr, index+1, target, sum+arr[index], ds, res) == true){
            return true;
        }
        ds.removeLast();
        if(get_SUbsequences(arr, index+1, target, sum, ds, res) == true){
            return true;
        }
        return false;
    }

    // count of subsequences with sum k
    public static int totalSubsequences(int[]arr , int index , int target , int sum){

        if(index == arr.length){
            if(sum == target){
                return 1;
            }
            return 0;   
        }
        int c1 = totalSubsequences(arr, index+1, target, sum+arr[index]);
        int c2 = totalSubsequences(arr, index+1, target, sum);
        return c1 + c2;
    }
    public static void main(String[] args) {
        int[]arr = {1,2,1};
        int k = 2;
        ArrayList<Integer>ds = new ArrayList<>();
        ArrayList<ArrayList<Integer>>res = new ArrayList<>();
        get_SUbsequences(arr, 0, k, 0, ds, res);
        // System.out.println(res);
        System.out.println(totalSubsequences(arr, 0, k, 0));

    }
    
}