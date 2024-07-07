import java.util.*;

public class baseBallGame {

    public static int calPoints(String[]operations){

        int n = operations.length;
        Stack<Integer>st = new Stack<>();

        for(int i = 0; i < n; i++){
            String s = operations[i];
            
            if(s == "C") st.pop();
            else if(s == "D") st.push(st.peek()*2);
            else if(s == "+"){
                int topVal = st.pop();
                int topVal_II = st.pop(); // 2nd from top
                st.push(topVal_II);
                st.push(topVal);
                st.push(topVal+topVal_II);
            }
            else{
                int val = Integer.parseInt(s);
                st.push(val);
            }
            
        }
        int totalScore = 0;
        while(!st.isEmpty()){
            totalScore += st.pop();
        }
        return totalScore;
    }
    
    public static void main(String[] args) {
        String[] ops = {"5","2","C","D","+"};
        System.out.println(calPoints(ops));
    }

}