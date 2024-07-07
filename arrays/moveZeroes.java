import java.util.*;

public class moveZeroes {
    
    public static ArrayList<Integer> move_Zero(int[]arr , int n){
        ArrayList<Integer>ls = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(arr[i] != 0){
                ls.add(arr[i]);
            }
        }
        int zerocount = n-ls.size();

        for(int i = 0; i < zerocount; i++){
            ls.add(0);
        }
        return ls;
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

        ArrayList<Integer>ls = move_Zero(arr, n);
    
        for(int ele : ls){
            System.out.print(ele+" ");
        }

        input.close();
    }
}
