import java.util.*;

public class repeatingAndMissing {
    
    public static int[]rep_miss(int[]arr , int n){
        int[]hash = new int[n+1];
        
        for(int i = 0; i < n; i++){
            hash[arr[i]]++;
        }
        int rep = -1 , miss = -1;

        for(int i = 1; i <= n; i++){
            if(hash[i] == 2) rep = i;
            if(hash[i] == 0) miss = i;
            if(rep != -1 && miss != -1) break;
        }

        int[]ans = {rep,miss};
        return ans;

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter the size of array : ");
        int n = input.nextInt();
        int[]arr = new int[n];
        System.out.println("enter the elements of array : ");
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }
        int[]ans = rep_miss(arr, n);
        System.out.println("repeating and missing elements are --> ");
        for(int i = 0; i < ans.length; i++){
            System.out.print(ans[i]+" ");
        }

        input.close();
    }

}
