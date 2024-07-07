import java.util.*;

public class revv{

    public static void reverse(ArrayList<Integer>ls , int s , int e){
        while(s <= e){
            int temp = ls.get(s);
            ls.set(s,ls.get(e));
            ls.set(e,temp);
            s++;e--;
        }
    }

    public static void main(String[]Args){
        Scanner input = new Scanner(System.in);
        System.out.print("enter the size of array : ");
        int n = input.nextInt();
        ArrayList<Integer>arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int ele = input.nextInt();
            arr.add(ele);
        }
        reverse(arr , 0 , n-1);
        System.out.println("Array after reversing : ");
        for(int x : arr){
            System.out.print(x+" ");
        }
        input.close();
    }

}