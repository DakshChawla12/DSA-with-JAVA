import java.util.*;

public class prefix_to_postfix {
    
    public static String preToPost(String str){

        int n = str.length();
        Stack<String>st = new Stack<>();

        for(int i = n-1; i >= 0; i--){
            char ch = str.charAt(i);
            int Ascii_val = (int)ch;

            if(Ascii_val >= 48 && Ascii_val <= 57){
                st.push(ch+"");
            }
            else{
                String val1 = st.pop();
                String val2 = st.pop();
                
                String t = val1+val2+ch;
                st.push(t);
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        String str = "-9/*+5346";
        System.out.println(preToPost(str));
    }

}
