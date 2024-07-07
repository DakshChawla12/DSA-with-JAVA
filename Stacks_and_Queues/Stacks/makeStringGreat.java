import java.util.*;

public class makeStringGreat {
    
    public static String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!st.isEmpty() && Math.abs(st.peek() - ch) == 32) {
                st.pop();
            } else {
                st.push(ch);
            }
        }

        StringBuilder result = new StringBuilder("");
        while (!st.isEmpty()) {
            result.append(st.pop());
        }
        result.reverse();
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "Pp";
        System.out.println(makeGood(s));
        
    }

}
