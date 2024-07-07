import java.util.Stack;
// poora code infix to postFix ka h bs jo string insert krni h usme order op v1 v2 ki jagah v1 v2 op hojega
public class infix_to_postfix {
    
    public static String convertInfixToPostFixString(String str){

        Stack<String>valueStack = new Stack<>();
        Stack<Character>operatorSTack = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            int Ascii_Val = (int)ch; // getting ascii value of current char
        // '0'(charecter) ki ascii value --> 48
        // '9'(charecter) ki ascii value --> 57     (baaki sbb inke beech m aate h)           
            if(Ascii_Val >= 48 && Ascii_Val <= 57){
                String s = ""+ch;
                valueStack.push(s);
            }
            else if(operatorSTack.size() == 0 || ch == '(' || operatorSTack.peek() == '('){
                operatorSTack.push(ch);
            }
            else if(ch == ')'){
                while(operatorSTack.peek() != '('){
                    // kaam niptado
                    String v2 = valueStack.pop();
                    String v1 = valueStack.pop();
                    char op = operatorSTack.pop();
                    String t = v1 + v2 + op;
                    valueStack.push(t);
                }
                operatorSTack.pop(); // dono brackets k beech ka kaam khtm hone k baad opening bracket ko htaado
            }
            else{ // ch number nhi h aur operator stack may koi aur operator pda hua h
                if(ch == '+' || ch == '-'){ // + - k case m kuch check nhi krna kyunki baakio ki precedence ya toh unke brabr h ya unse zyada h
                    // kaam niptado
                    String v2 = valueStack.pop();
                    String v1 = valueStack.pop();
                    char op = operatorSTack.pop();
                    String t = op + v1 + v2;
                    valueStack.push(t);

                    operatorSTack.push(ch); // current operator ko daaldo
                }
                else if(ch == '*' || ch == '/'){
                    if(operatorSTack.peek() == '*' || operatorSTack.peek() == '/'){
                        // kaam niptado
                    String v2 = valueStack.pop();
                    String v1 = valueStack.pop();
                    char op = operatorSTack.pop();
                    String t =  v1 + v2 + op;
                    valueStack.push(t);
                    operatorSTack.push(ch); // current operator ko daaldo
                    }
                    else{
                        operatorSTack.push(ch);
                    }
                }
            }
        }

        // poori string traverse krne k baad
        // valuestack ka size 1 bnana h
        while(valueStack.size() > 1){
            String v2 = valueStack.pop();
            String v1 = valueStack.pop();
            char op = operatorSTack.pop();
            String t =  v1 + v2 + op;
            valueStack.push(t);
        }
        return valueStack.peek();
    }

    public static void main(String[] args) {
        String str = "9-(5+3)*4/6";
        System.out.println(str);
        System.out.println(convertInfixToPostFixString(str));
    }

}
