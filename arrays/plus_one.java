import java.util.Scanner;

public class plus_one {

    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            // Swap elements
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            
            // Move pointers
            start++;
            end--;
        }
    }
    
    public static int[]plusOne(int[]digits){

        int n = digits.length;
        int carry = 1;


        for(int i = n-1; i >= 0; i--){
            int sum = carry+digits[i];
            digits[i] = sum%10;
            carry = sum/10;
            if(carry == 0){
                return digits;
            }
        }
        int[]ans = new int[n+1];
        ans[0] = carry;
        // System.arraycopy(sourceArray, sourceStartIndex, destinationArray, destinationStartIndex, length);

        System.arraycopy(digits, 0, ans, 1, n);
        return ans;

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter the length of array : ");
        int n = input.nextInt();
        int[]arr = new int[n];
        System.out.println("enter the elements of array : ");
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }
        System.out.println("ans --> ");
        int[]ans = plusOne(arr);
        
        for(int i = 0; i < ans.length; i++){
            System.out.print(ans[i] + " ");
        }

        input.close();
    }

}
