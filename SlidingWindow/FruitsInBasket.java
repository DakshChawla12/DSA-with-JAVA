import java.util.*;
public class FruitsInBasket {
    public static int findMaxFruits(int []arr) {

        int n = arr.length;;
        int l = 0 , r = 0 , maxLen = 0;
        HashMap<Integer,Integer>mpp = new HashMap<>();

        while(r < n){

            mpp.put(arr[r],mpp.getOrDefault(arr[r],0)+1);

            if(mpp.size() <= 2){
                maxLen = Math.max(maxLen,r-l+1);
            }

            while(mpp.size() > 2){
               mpp.put(arr[l], mpp.get(arr[l]-1));
                if(mpp.get(arr[l]) == 0){
                    mpp.remove(arr[l]);
                }
                l++;
            }
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[]arr = {1,1,2,3};
        System.out.println(findMaxFruits(arr));
    }

}
