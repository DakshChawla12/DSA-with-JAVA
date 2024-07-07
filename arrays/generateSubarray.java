import java.util.*;

public class generateSubarray {
    public static void generate_Subarray(int[]arr , int n){
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int sum = 0;
                for(int k = i; k <= j; k++){
                    sum += arr[k];
                    if(sum > maxi){
                        maxi = sum;
                    }
                }
                
            }
        }
        System.out.println(maxi);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter the length of array : ");
        int n = input.nextInt();
        int[]arr = new int[n];
        System.out.println("enter the values of array : ");
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }
        System.out.println("Max subarray sum is : ");
        generate_Subarray(arr,n);
        
        input.close();
    }

}
