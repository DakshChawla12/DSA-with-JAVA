

public class subset {
    
public static void printSubset(String processed, String unprocessed) {
    // Base case: If the unprocessed string is empty, print the processed subset and return.
    if (unprocessed.isEmpty()) {
        System.out.println(processed);
        return;
    }

    // Recursive case:
    //  Include the current character in the subset and make a recursive call.
    char currentChar = unprocessed.charAt(0);
    printSubset(processed + currentChar, unprocessed.substring(1));

    // . Exclude the current character from the subset and make a recursive call.
    printSubset(processed, unprocessed.substring(1));
}


    public static void main(String[] args) {
        String str = "abc" , res = "";
        printSubset(res, str);
    }

}
