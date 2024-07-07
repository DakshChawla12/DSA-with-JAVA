import java.util.*;

public class balancedPara {
    
    public static boolean isValidPara(String str) {
        Stack<Character> st = new Stack<>();
    
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (st.isEmpty()) {
                    return false;
                }
                char temp = st.pop();
                if ((ch == ')' && temp != '(') || (ch == ']' && temp != '[') || (ch == '}' && temp != '{')) {
                    return false;
                }
            }
        }
        
        return st.isEmpty();
    }
    
    public static int isValidPara_II(String str) {
        Stack<Character> st = new Stack<>();
        int count = 0;

        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (st.isEmpty()) {
                    count++;
                } else {
                    char temp = st.pop();
                    if ((ch == ')' && temp != '(') || (ch == ']' && temp != '[') || (ch == '}' && temp != '{')) {
                        count++;
                    }
                }
            }
        }

        count += st.size(); // Add count for unmatched opening brackets

        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("enter the brackets to evaluate : ");
        String str = input.nextLine();
        System.out.println(isValidPara(str));

        input.close();
    }

}
