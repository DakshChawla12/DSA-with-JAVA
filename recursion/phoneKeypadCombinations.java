
public class phoneKeypadCombinations {

    public static void Combinations(String digits, String[] kp, String res){

        // Base case: If there are no more digits left to process, print the current combination.
        if(digits.length() == 0){
            System.out.print(res + " ");
            return;
        }
    
        // Extract the first digit from the input sequence.
        int currNum = digits.charAt(0) - '0';
    
        // Get the string of corresponding letters for the current digit from the keypad mapping.
        String currChoices = kp[currNum];
    
        // Iterate through each letter corresponding to the current digit.
        for(int i = 0; i < currChoices.length(); i++){
            // Recursively call Combinations with the remaining digits and the updated combination.
            Combinations(digits.substring(1), kp, res + currChoices.charAt(i));
        }
    }
    public static void main(String[] args) {
        String str = "253";
        String[]kp = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        //            0   1    2       3      4      5      6      7       8      9
        Combinations(str, kp, "");
    }   
    
}