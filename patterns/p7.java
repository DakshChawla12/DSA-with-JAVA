import java.util.Scanner;

public class p7 {
    
    public static void pattern7(int n){ // butterfly
        //upper part
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                System.out.print("*");
            }
            for(int j = n-i; j > 0; j--){
                System.out.print(" ");
            }
            for(int j = n-i; j > 0; j--){
                System.out.print(" ");
            }
            for(int j = 0; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i = 0; i < n; i++){
            for(int j = n-i; j > 0; j--){
                System.out.print("*");
            }
            for(int j = 0; j <= i; j++){
                System.out.print(" ");
            }
            for(int j = 0; j <= i; j++){
                System.out.print(" ");
            }
            for(int j = n-i; j > 0; j--){
                System.out.print("*");
            }
            System.out.println();
        }
        
    }

    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        System.out.println("enter the value of n : ");
        int n = input.nextInt();
        pattern7(n);

        input.close();
    }

}
