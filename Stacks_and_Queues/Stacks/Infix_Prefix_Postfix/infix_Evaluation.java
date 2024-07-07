import java.util.*;

public class infix_Evaluation {

    public static int eval_Infix(String str){

        Stack<Integer>valueStack = new Stack<>();
        Stack<Character>operatorSTack = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            int Ascii_Val = (int)ch; // getting ascii value of current char
        // '0'(charecter) ki ascii value --> 48
        // '9'(charecter) ki ascii value --> 57     (baaki sbb inke beech m aate h)           
            if(Ascii_Val >= 48 && Ascii_Val <= 57){
                int currDigit = Ascii_Val-48;   // agr current char integer h to uski ascii val may se 48 minus krke uski integer value mill jaayegi
                valueStack.push(currDigit);
            }
            else if(operatorSTack.size() == 0 || ch == '(' || operatorSTack.peek() == '('){
                operatorSTack.push(ch);
            }
            else if(ch == ')'){
                while(operatorSTack.peek() != '('){
                    // kaam niptado
                    int v2 = valueStack.pop();
                    int v1 = valueStack.pop();

                    if(operatorSTack.peek() == '-') valueStack.push(v1-v2);
                    else if(operatorSTack.peek() == '+') valueStack.push(v1+v2);
                    else if(operatorSTack.peek() == '*') valueStack.push(v1*v2);
                    else if(operatorSTack.peek() == '/') valueStack.push(v1/v2);
                    
                    operatorSTack.pop(); // jo operator evaluate ho gya h usko hta do stack se
                }
                operatorSTack.pop(); // dono brackets k beech ka kaam khtm hone k baad opening bracket ko htaado
            }
            else{ // ch number nhi h aur operator stack may koi aur operator pda hua h
                if(ch == '+' || ch == '-'){ // + - k case m kuch check nhi krna kyunki baakio ki precedence ya toh unke brabr h ya unse zyada h
                    // kaam niptado
                    int v2 = valueStack.pop();
                    int v1 = valueStack.pop();

                    if(operatorSTack.peek() == '-') valueStack.push(v1-v2);
                    else if(operatorSTack.peek() == '+') valueStack.push(v1+v2);
                    else if(operatorSTack.peek() == '*') valueStack.push(v1*v2);
                    else if(operatorSTack.peek() == '/') valueStack.push(v1/v2);
                    
                    operatorSTack.pop(); // jo operator evaluate ho gya h usko hta do stack se
                    operatorSTack.push(ch); // current operator ko daaldo
                }
                else if(ch == '*' || ch == '/'){
                    if(operatorSTack.peek() == '*' || operatorSTack.peek() == '/'){
                        // kaam niptado
                    int v2 = valueStack.pop();
                    int v1 = valueStack.pop();

                    if(operatorSTack.peek() == '*') valueStack.push(v1*v2);
                    else if(operatorSTack.peek() == '/') valueStack.push(v1/v2);
                    
                    operatorSTack.pop(); // jo operator evaluate ho gya h usko hta do stack se
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
            int v2 = valueStack.pop();
            int v1 = valueStack.pop();

            if(operatorSTack.peek() == '-') valueStack.push(v1-v2);
            else if(operatorSTack.peek() == '+') valueStack.push(v1+v2);
            else if(operatorSTack.peek() == '*') valueStack.push(v1*v2);
            else if(operatorSTack.peek() == '/') valueStack.push(v1/v2);
        
            operatorSTack.pop();
        }
        return valueStack.peek();
    }
    public static void main(String[] args) {
        String str = "9-(5+3)*4/6";
        int res = eval_Infix(str);
        System.out.println(res);
    }

}