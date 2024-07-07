public class skipAchar {
    
    public static String skipChar(String str , String res , int index , int n , char toSkip){
        if(n == 0 || index >= n){
            return res;
        }
        if(str.charAt(index) != toSkip){
            res  = res + str.charAt(index);
        }
        return skipChar(str, res, index+1, n, toSkip);
    }

    public static String skip_char(String str, int n, char toSkip) {
    // Base case: If the desired length is 0, return an empty string

    // System.out.println(str);

    if (n == 0) {
        return "";
    }

    // Get the current character at index 0
    char currentChar = str.charAt(0);

    // Conditional recursion: If the current character is equal to toSkip, skip it
    if (currentChar == toSkip) {
        return skip_char(str.substring(1), n - 1, toSkip);
    } else {
        // If the current character is not equal to toSkip, include it in the result
        // and make a recursive call with the updated string and decremented n
        return currentChar + skip_char(str.substring(1), n - 1, toSkip);
    }
}

    public static String Skip_Part(String str , String partToSkip){
        // System.out.println(str);
        if(str.isEmpty()){
            return "";
        }
        if(str.startsWith(partToSkip)){
            return Skip_Part(str.substring(partToSkip.length()), partToSkip);
        }
        else{
            return str.charAt(0) + Skip_Part(str.substring(1), partToSkip);
        }

    }

    public static String Skip_Part_II(String str){
        if(str.isEmpty()){
            return "";
        }
        if(str.startsWith("app") && !str.startsWith("apple")){
            return Skip_Part_II(str.substring(3));     // general case may 0 ki jagah jonsa part skip krna h uski length aayegi
        }
        else{
            return str.charAt(0) + Skip_Part_II(str.substring(1));
        }
    }

    public static void main(String[] args) {
        // String str = "baccdahhccda" , res;
        // res = Skip_Part(str, "ccd");

        String str = "appbcdapple";
        String res = Skip_Part_II(str);
        System.out.println(res);
    }

}
