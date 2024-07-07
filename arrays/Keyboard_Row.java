import java.util.ArrayList;

public class Keyboard_Row {

    public static boolean wordCheck(String s , String row){
        char[]arr1 = s.toCharArray();
        char[]arr2 = row.toCharArray();

        for(char c : arr1){
            boolean temp = false;
            for(char ch : arr2){
                if(c == ch){
                    temp = true;
                    break;
                }
            }
            if(temp == false){
                return false;
            }
        }
        return true;
    }
    
    public static String[] findWords(String[]words){

        int n = words.length;
        ArrayList<String>ls = new ArrayList<>();

        String one = "qwertyuiop";
        String two = "asdfghjkl";
        String three = "zxcvbnm";

        for(int i = 0; i < n; i++){
            if(wordCheck(words[i],one) || wordCheck(words[i],two) || wordCheck(words[i],three)){
                ls.add(words[i]);
            }
        }

        int k = 0;
        String[]res = new String[ls.size()];

        for(String str : ls){
            res[k] = str;
            k++;
        }

        return res;

    }

}
