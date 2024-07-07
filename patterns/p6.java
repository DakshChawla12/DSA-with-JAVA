import java.util.*;

public class p6 {
    
    public static void pattern6(int n){ // 1-0 triangle
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                if((i+j)%2 == 0){
                    System.out.print(1+" ");
                }
                else{
                    System.out.print(0+" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        System.out.println("enter the value of n : ");
        int n = input.nextInt();
        pattern6(n);

        input.close();
    }

}
