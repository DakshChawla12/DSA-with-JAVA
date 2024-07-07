import java.util.*;

public class reverseWordsInString {

    public static void swapp(char[]arr , int s , int e){
        while(s <= e){
            char temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;e--;
        }
    }

    public static String toArray(String str){
        char[]ans = str.toCharArray();
        int i = 0 , j = 0;

        while(j < ans.length){
            while(j < ans.length && ans[j] != ' '){
                j++;
            }
            swapp(ans,i,j-1);
            i = j + 1;
            j = i;
        }
        String res = new String(ans);
        return res;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String org = "Let's take LeetCode contest";
        System.out.print("Original String is -->" + org);
        System.out.println();
        String ans = toArray(org);
        System.out.print("String after modification -->" + ans);

        input.close();
    }

}