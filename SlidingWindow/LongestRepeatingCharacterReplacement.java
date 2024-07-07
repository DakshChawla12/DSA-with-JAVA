public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {

        int n = s.length();
        int l = 0 , r = 0 , maxLen = 0 , maxFreq = 0;
        int[]hash = new int[26];

        while(r < n){

            char ch = s.charAt(r);
            hash[ch-'A']++;

            maxFreq = Math.max(maxFreq,hash[ch -'A']);
            while((r-l+1)-maxFreq > k){
                char c = s.charAt(l);
                hash[c-'A']--;
                for(int i = 0; i < 26; i++){
                    maxFreq = Math.max(maxFreq,hash[i]);
                }
                l++;
            }
            if((r-l+1) - maxFreq <= k){
                maxLen = Math.max(maxLen,r-l+1);
            }
            r++;
        }
        return maxLen;
    }

}
