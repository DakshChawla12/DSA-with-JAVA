import java.util.*;
public class LongestSubstringWithAtMostKDistinctCharacters {

    public static int findLongest(String s , int k){

        int n = s.length();
        int l = 0 , r = 0 , maxLen = 0;
        HashMap<Character,Integer>mpp = new HashMap<>();

        while(r < n){

            char ch = s.charAt(r);
            mpp.put(ch , mpp.getOrDefault(ch,0)+1);

            while(mpp.size() > k){
                char c = s.charAt(l);
                mpp.put(c,mpp.get(c)-1);
                if(mpp.get(c) == 0){
                    mpp.remove(c);
                }
                l++;
            }

            if(mpp.size() <= k){
                maxLen = Math.max(maxLen,(r-l+1));
            }

            r++;

        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "aaabbccd";
        System.out.println(findLongest(s,2));
    }

}
