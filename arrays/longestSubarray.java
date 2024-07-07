import java.util.*;

class longestSubarray {

        public static int findLongest(int[]arr , int n , int target){
            int maxi = -1;
            for(int i = 0; i < n; i++){
                for(int j = i; j < n; j++){
                    int sum = 0;
                    for(int k = i; k <= j; k++){
                        sum += arr[k];
                    }
                    if(sum == target){
                        maxi = Math.max(maxi, j-i+1);
                    }
                }
            }
            return maxi;
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
            System.out.print("enter target : ");
            int target  = input.nextInt();

            System.out.print("maximum subarray length with sum k is --> "+findLongest(arr, n, target));
            input.close();
        }

}