import java.util.*;

public class rotate {
    
    public static void swapp(int[]arr , int s , int e){
        while(s <= e){
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;e--;
        }
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
        System.out.print("enter the number of rotations : ");
        int k = input.nextInt();
        k = k % n;

        swapp(arr, 0, n-1-k);
        swapp(arr, n-k, n-1);
        swapp(arr, 0, n-1);


        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }

        input.close();
    }

}
