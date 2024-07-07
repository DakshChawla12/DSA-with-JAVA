import java.util.*;

public class p1{

    public static void pattern1(int n){ // half pyramid
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                System.out.print("*"+' ');
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter value of n : ");
        int n = input.nextInt();
        pattern1(n);

        input.close();
    }
}