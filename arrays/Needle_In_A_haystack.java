public class Needle_In_A_haystack {

    
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int ans = -1;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                String substring = haystack.substring(i,j+1);
                if(substring.equals(needle)){
                    ans = i;
                    return ans;
                }
            }
        }
        return ans;
    }
}

// ***** inbuilt function *****
 // return haystack.indexOf(needle);

