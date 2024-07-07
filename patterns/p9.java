import java.util.*;;

public class p9 {
    
    public static void pattern9(int n){
        for(int i=1; i<=n; i++) {
            //spaces
            for(int j=1; j<=n-i; j++) {
                System.out.print(" ");
            }


            //first part
            for(int j=i; j>=1; j--) {
                System.out.print(j);
            }


            //second part
            for(int j=2; j<=i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter value of n : ");
        int n = input.nextInt();
        pattern9(n);

        input.close();
    }

}
