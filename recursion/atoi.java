
public class atoi {
    
    public static int helper(String str , int idx , int res , boolean negative){
        if (idx == str.length() || (str.charAt(idx) < '0' || str.charAt(idx) > '9')) {
            if (negative) {
                return -res;
            } else {
                return res;
            }
        }
        
        int ascii = str.charAt(idx);
        int digit = ascii - '0'; // Subtract the ASCII value of '0' to get the numeric value of the digit
        
        // Check for overflow before updating the result
        if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > 7)) {
            if (negative) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        
        res = (res * 10) + digit;
        return helper(str, idx + 1, res, negative);
    }

    public static int myAtoi(String s) {
        if(s.length() == 0) return 0;
        String str = s.trim();
        if(str.length() == 0) return 0;
        char ch = str.charAt(0);
        boolean negative = false;
        if(ch == '-'){
            negative = true;
            return helper(str,1,0,negative);
        }
        else if(ch == '+'){
            return helper(str,1,0,negative);
        }
        return helper(str,0,0,negative);
    }

    public static void main(String[] args) {
        String s = "-42 abc";
        System.out.println(myAtoi(s));
    }

}
