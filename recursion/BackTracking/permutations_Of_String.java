import java.util.ArrayList;
import java.util.List;

public class permutations_Of_String {

    public static void printPermutations(String str , String t, List<String> ls){

        if(str.equals("")){
            ls.add(t);
            return;
        }
        System.out.println(t);
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            String left = str.substring(0, i); // left part of current character
            String right = str.substring(i+1); // right part of current character

            String rem = left+right;
            printPermutations(rem,t+ch,ls);
        }

    }

    public static void main(String[] args) {
        String str = "abc";
        List<String> ls = new ArrayList<>();
        printPermutations(str,"",ls);
        System.out.println(ls);
    }

}
