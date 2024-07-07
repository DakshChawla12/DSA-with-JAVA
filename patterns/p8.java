import java.util.*;

public class p8 {
    
    public static void pattern8(int n){ // rhombus
        for(int i = 0; i < n; i++){
            for(int j = n-i; j > 0; j--){
                System.out.print(" ");
            }
            for(int j = 0; j < n; j++){
                System.out.print("* ");
            }
            for(int j = 0; j <= i; j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter value of n : ");
        int n = input.nextInt();
        pattern8(n);

        input.close();
    }

}
