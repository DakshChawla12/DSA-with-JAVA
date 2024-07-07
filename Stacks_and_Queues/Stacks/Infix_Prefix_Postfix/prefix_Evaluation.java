import java.util.*;
// postfix evaluation jaisa he h bss loop ulta chlta h
// aur isme val1 top wala hoga aur val2 uske neech waala
public class prefix_Evaluation {
    
    public static int evaluate_Prefix(String str){
        
        int n = str.length();
        Stack<Integer>st = new Stack<>();

        for(int i = n-1; i >= 0; i--){
            char ch = str.charAt(i);
            int Ascii_val = (int)ch;

            if(Ascii_val >= 48 && Ascii_val <= 57){
                st.push(Ascii_val-48);
            }
            else{
                int val1 = st.pop();
                int val2 = st.pop();

                if(ch == '+') st.push(val1+val2);
                else if(ch == '-') st.push(val1-val2);
                else if(ch == '*') st.push(val1*val2);
                else if(ch == '/') st.push(val1/val2);    
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        String str = "-9/*+5346";
        System.out.println(evaluate_Prefix(str));
    }

}
