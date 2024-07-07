import java.util.*;

public class p5 {
    
    public static void pattern5(int n){ // inverted half pyramid
        for(int i = 0; i < n; i++){
            for(int j = n-i; j > 0; j--){
                System.out.print(" ");
            }
            for(int j = 0; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        System.out.println("enter the value of n : ");
        int n = input.nextInt();
        pattern5(n);

        input.close();
    }

}
