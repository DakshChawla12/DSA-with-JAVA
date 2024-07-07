import java.util.*;

public class p4 {
    
    public static void pattern4(int n){ // reverse half pyramid
        for(int i = 0; i < n; i++){
            for(int j = n-i; j > 0; j--){
                System.out.print("*"+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        System.out.println("enter the value of n : ");
        int n = input.nextInt();
        pattern4(n);
        input.close();
    }

}
