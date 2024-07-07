import java.util.*;

public class union {
    
    public static ArrayList<Integer> findUnion(int[]arr , int n , int[]brr , int m){
        ArrayList<Integer>Result = new ArrayList<>();

        int i = 0 , j = 0;

        while (i < n && j < m) {
            if(arr[i] == brr[j]){
                Result.add(arr[i]);
                i++;j++;
            }
            else if(arr[i] > arr[j]){
                j++;
            }
            else{
                i++;
            }
        }
        
        return Result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("enter the length of 1st array : ");
        int n = input.nextInt();
        int[]arr = new int[n];
        System.out.println("enter the elements of 1st array : ");
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }

        System.out.print("enter the length of 2nd array : ");
        int m = input.nextInt();
        int[]brr = new int[m];
        System.out.println("enter the elements of 2nd array : ");
        for(int i = 0; i < m; i++){
            brr[i] = input.nextInt();
        }

        ArrayList<Integer>ls = findUnion(arr, n, brr, m);
        System.out.println(ls);

        input.close();

    }

}
