
public class rotateString {


public static void rightShift(char[] arr) {
    char temp = arr[0]; // Store the first element of the array
    int n = arr.length; 
    for (int i = 0; i < n - 1; i++) {
        arr[i] = arr[i + 1]; // Shift each element one position to the left
    }
    arr[n - 1] = temp; // Place the initially stored element at the end
}

// Function to check if a string 's' can be rotated to match another string 'goal'
public boolean rotate_String(String s, String goal) {
    char[] arr = s.toCharArray(); 
    int n = arr.length; 
    boolean ans = false;
    for (int i = 0; i < n; i++) {
        rightShift(arr); // Perform a right shift operation on the character array
        // Check if the rotated string matches the 'goal' string
        if (String.valueOf(arr).equals(goal)) {
            ans = true; // Update the flag if a match is found
            break; // Exit the loop as a match is found
        }
    }
    return ans; 
}
    
    public static void main(String[] args) {
        String str = "abcde";
        char[]arr = str.toCharArray();

        rightShift(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
        }
    }

}