import java.util.*;

public class postfix_to_prefix {
    
    public static String postToPre(String str){

        int n = str.length();
        Stack<String>st = new Stack<>();

        for(int i = 0; i < n; i++){
            char ch = str.charAt(i);
            int Ascii_val = (int)ch;

            if(Ascii_val >= 48 && Ascii_val <= 57){
                st.push(ch+"");
            }
            else{
                String val2 = st.pop();
                String val1 = st.pop();
                
                String t = ch+val1+val2;
                st.push(t);
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        String str = "953+4*6/-";
        System.out.println(postToPre(str));
    }

}
