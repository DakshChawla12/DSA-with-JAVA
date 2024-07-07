import java.util.*;

public class q2 {
    
    // insert an element at the bottom of stack
    public static void insertAtBottom(customStack st , int x){
        customStack temp = new customStack();
        while(!st.isEmpty()){
            temp.push(st.pop());
        }
        st.push(x);
        while(!temp.isEmpty()){
            st.push(temp.pop());
        }
    }

    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("enter the number of elements to add in stack : ");
        int n = input.nextInt();
        
        customStack st = new customStack(n);

        System.out.println("enter the elements : ");
        for(int i = 0; i < n; i++){
            int x = input.nextInt();
            st.push(x);
        }
        insertAtBottom(st ,2);
        st.display();

        input.close();
    }

}
