// copy elements of one stack into another in same order
import java.util.*;

public class q1 {

    public static void moveStacks(customStack s1 , customStack s2){

        customStack temp = new customStack();
        while(!s1.isEmpty()){
            temp.push(s1.pop());
        }
        while(!temp.isEmpty()){
            s2.push(temp.pop());
        }

    }
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        customStack st1 = new customStack();
        customStack st2 = new customStack();

        System.out.print("enter the number of elements to add in stack : ");
        int n = input.nextInt();

        System.out.println("enter the elements : ");
        for(int i = 0; i < n; i++){
            int x = input.nextInt();
            st1.push(x);
        }

        moveStacks(st1, st2);

        st2.display();

        input.close();

    }
    
}