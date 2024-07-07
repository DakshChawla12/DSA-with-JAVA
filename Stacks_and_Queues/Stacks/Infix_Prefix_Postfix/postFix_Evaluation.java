import java.util.*;

public class postFix_Evaluation {
    
    public static int evaluate_Postfix(String str){

        int n = str.length();
        Stack<Integer>st = new Stack<>();

        for(int i = 0; i < n; i++){
            char ch = str.charAt(i);
            int Ascii_val = (int)ch;

            if(Ascii_val >= 48 && Ascii_val <= 57){
                st.push(Ascii_val-48);
            }
            else{
                int val2 = st.pop();
                int val1 = st.pop();

                if(ch == '+') st.push(val1+val2);
                else if(ch == '-') st.push(val1-val2);
                else if(ch == '*') st.push(val1*val2);
                else if(ch == '/') st.push(val1/val2);    
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        String str = "953+4*6/-";
        System.out.println(evaluate_Postfix(str));
    }

}
