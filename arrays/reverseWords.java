

public class reverseWords {
    
    public static String revv(String str) {
        int n = str.length();
        int i = n - 1, j = n - 1;
        String res = "";
    
        while (i >= 0) {
            while (j >= 0 && str.charAt(j) != ' ') {
                j--;
            }
    
            String substr = str.substring(j + 1, i + 1);
            res = res.concat(substr).concat(" ");
    
            while (j >= 0 && str.charAt(j) == ' ') {
                j--;
            }
    
            i = j;
        }
        return res.trim();
    }
    
    public static void main(String[] args) {
        String s = "the sky is blue";
        String res = revv(s);
        System.out.println(res);
    }

}
