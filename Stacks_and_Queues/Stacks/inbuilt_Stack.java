import java.util.*;

public class inbuilt_Stack {
    
    public static void main(String[] args) {
        Stack<Integer>st = new Stack<>();
        st.push(0);
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        /* pop function return the integer that is popped */
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        

    }

}
