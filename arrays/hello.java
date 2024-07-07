import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class hello {

    public static void helper(int i , int n , int r , int[]arr , ArrayList<ArrayList<Integer>>ls , ArrayList<Integer>ds){

        if(i == n){
            if(ds.size() == r){
                ls.add(new ArrayList<>(ds));
            }
            return;
        }

        ds.add(arr[i]);
        helper(i+1 , n , r , arr , ls , ds) ;
        ds.removeLast();
        helper(i+1 , n , r , arr , ls , ds) ;

    }

    public static void main(String[] args) {
        int[]arr = {2,1,3};
        Arrays.sort(arr);

        ArrayList<ArrayList<Integer>>ls = new ArrayList<>();
        helper(0,3,2,arr,ls,new ArrayList<>());

        System.out.println(ls);

    }

}