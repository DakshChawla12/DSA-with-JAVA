import java.util.*;

class leadersInArray {

    public static ArrayList<Integer>leaders(int[]arr , int n){
        ArrayList<Integer>ls = new ArrayList<>();
        for(int i = 0; i < n; i++){
            boolean flag = true;
            for(int j = i+1; j < n; j++){
                if(arr[j] > arr[i]){
                    flag = false;
                }
            }
            if(flag) ls.add(arr[i]);
        }
        return ls;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter the length of array : ");
        int n = input.nextInt();
        int[]arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }
        ArrayList<Integer>ans = leaders(arr, n);
        System.out.print("leaders in the given array is/are --> "+ans);

        input.close();
    }
    
}