import java.util.*;

public class p3 {
    
    public static void pattern3(int n){ // holllow square
        int k = n-1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if((i == 0 || j == 0 || i == k || j == k)){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void pattern3__2ndVariation(int n){ // hollow rectangle
        int k = n-1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n+1; j++){
                if((i == 0 || j == 0 || i == k || j == n)){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter the value of n");
        int n = input.nextInt();
        pattern3__2ndVariation(n);

        input.close();
        
    }

}
