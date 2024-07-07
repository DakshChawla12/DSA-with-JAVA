import java.util.*;

public class LongestSubsWithoutRep {
    
    public int lengthOfLongestSubstring(String s) { // optimised approach (independent h call nhi hora)
        if(s.length() == 0){
            return 0;
        }
    
        int maxLength = 0;
        int left = 0;
        int right = 0;
        HashSet<Character> set = new HashSet<>();
    
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                maxLength = Math.max(maxLength, set.size());
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
    
        return maxLength;
    }


    public static boolean valid_Subs(String str){ // my approach (986/987 testcases passed) (ye waala main se call hora h)
        HashSet<Character> set = new HashSet<>();
        for (char ch : str.toCharArray()) {
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.print("enter a string : ");
        String str = input.nextLine();

        int maxi = -1;

        for(int i = 0; i < str.length(); i++){
            for(int j = i; j <= str.length(); j++){
                String substring = str.substring(i, j);
                if(valid_Subs(substring)){
                    maxi = Math.max(maxi, substring.length());
                }
            }
        }
        System.out.println("longest substring length without repeating is -->" + maxi);

        input.close();
    }

}
