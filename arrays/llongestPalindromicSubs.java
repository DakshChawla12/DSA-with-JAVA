import java.util.*;

class llongestPalindromicSubs {

    public static boolean isPalindrome(String str , int s , int e){ 
        while(s <= e){
            if(str.charAt(s) != str.charAt(e)){
                return false;
            }
            s++;e--;
        }
        return true;
    }

    public static String longest_palindrome(String str){

        String res = "";
        int maxi = -1;
        for (int i = 0; i < str.length(); i++) {
            for (int j = str.length() - 1; j >= i; j--) { // Adjust the upper limit of j
                int len = (j - i) + 1;
                if (isPalindrome(str, i, j) && len > maxi) {
                    res = str.substring(i, j + 1);
                    maxi = len;
                }
            }
        }
        return res;
    }


    
    
    
    

    public static void main(String[] args) {    // *** function to get its length ***
        Scanner input = new Scanner(System.in);

        System.out.print("enter a string : ");
        String str = input.nextLine();

        int maxi = -1;

        for(int i = 0; i < str.length(); i++){

            for(int j = i; j < str.length(); j++){
                if(isPalindrome(str,i,j)){
                    maxi = Math.max(maxi, (j-i)+1);
                }
            }
        }
        String result = longest_palindrome(str);
        System.out.println("longest palindromic substring is --> "+ result +" and its length is --> "+maxi);
        input.close();
    }
    

}