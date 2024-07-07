import java.util.*;

public class p2 {

    public static void pattern2(int n){ // floyd's triangle
        int k = 1;

        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                System.out.print(k+" ");
                k++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter the value of n : ");
        int n = input.nextInt();
        pattern2(n);
        input.close();
    }

}
