import java.util.ArrayList;
import java.util.List;

public class palindromePartitioning {

    public boolean isPalindrome(String str , int s , int e){
        while(s <= e){
            if(str.charAt(s++) != str.charAt(e--)) return false;
        }
        return true;
    }

    public void helper(String s , int idx , List<String>ds , List<List<String>>res){
        if(idx == s.length()){
            res.add(new ArrayList<>(ds));
            return;
        }
        for(int i = idx; i < s.length(); i++){
            if(isPalindrome(s,idx,i)){
                ds.add(s.substring(idx,i+1));
                helper(s,i+1,ds,res);
                ds.remove(ds.size()-1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<String>ds = new ArrayList<>();
        List<List<String>>res = new ArrayList<>();
        helper(s,0,ds,res);
        return res;
    }

}
