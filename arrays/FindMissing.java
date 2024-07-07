import java.util.*;

public class FindMissing {
    
    public static int MissingNum(ArrayList<Integer> arr , int n){
        int m = arr.size();
        int sum1 = 0;
        for(int i = 0; i < n; i++){
            sum1 += i;
        }
        int sum2 = 0;
        for(int i = 0; i < m; i++){
            sum2 += arr.get(i);
        }
        return sum1-sum2;
    }


}
