import java.util.*;
public class ShopInCandyStore {

    public static ArrayList<Integer> candyStore(int[] candies, int N, int K){
        Arrays.sort(candies);
        int mini = 0 , buy = 0 , free = N-1;

        while(buy <= free){
            mini += candies[buy];
            buy++;
            free -= K;
        }

        int maxi = 0; buy = N-1; free = 0;

        while(free <= buy){
            maxi += candies[buy];
            buy--;
            free += K;
        }

        ArrayList<Integer>ls = new ArrayList<>();
        ls.add(mini);
        ls.add(maxi);

        return ls;
    }

    public static void main(String[] args) {
        int[]arr = {3,2,1,4};
        System.out.println(candyStore(arr , arr.length , 2));
    }

}
