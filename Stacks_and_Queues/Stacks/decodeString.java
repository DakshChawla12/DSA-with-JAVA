import java.util.Stack;

public class decodeString {

    public static String String_decoder(String s) {

        int n = s.length();
        Stack<Integer> val = new Stack<>();
        Stack<String> str = new Stack<>();
        int k = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                k = (k * 10) + (ch - '0');
            } else {
                if (Character.isLetter(ch)) {
                    str.push(String.valueOf(ch));
                } else if (ch == '[') {
                    val.push(k);
                    k = 0;
                    str.push(String.valueOf(ch));
                } else if (ch == ']') {
                    StringBuilder temp = new StringBuilder();
                    while (!str.peek().equals("[")) {
                        temp.insert(0, str.pop());
                    }
                    str.pop(); // pop '['
                    StringBuilder rep = new StringBuilder();
                    int count = val.pop();
                    for (int j = 0; j < count; j++) {
                        rep.append(temp.toString());
                    }
                    str.push(rep.toString());
                }
            }
        }

        StringBuilder result = new StringBuilder();
        while (!str.empty()) {
            result.insert(0, str.pop());
        }

        return result.toString();
    }
    

    

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(String_decoder(s));
    }
}
