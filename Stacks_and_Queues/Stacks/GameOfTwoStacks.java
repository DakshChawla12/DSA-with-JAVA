import java.util.*;
public class GameOfTwoStacks {
    
    public static int maxMoves(int target, int[] stack1, int[] stack2) {
        // Calling the recursive helper function with initial parameters.
        return countMaxMoves(target, stack1, stack2, 0, 0) - 1;
    }

    public static int countMaxMoves(int target, int[] stack1, int[] stack2, int sumSoFar, int count) {
        // Base case: If the current sum exceeds the target, return the current count.
        if (sumSoFar > target) {
            return count;
        }
    
        // Base case: If either of the stacks is empty, return the current count.
        if (stack1.length == 0 || stack2.length == 0) {
            return count;
        }
    
        // Calculate the maximum moves by selecting the first element from each stack.
        int ans1 = countMaxMoves(target, Arrays.copyOfRange(stack1, 1, stack1.length), stack2, sumSoFar + stack1[0], count + 1);
        int ans2 = countMaxMoves(target, stack1, Arrays.copyOfRange(stack2, 1, stack2.length), sumSoFar + stack2[0], count + 1);
    
        // Return the maximum of the two possibilities.
        return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int numberOfTestcases = input.nextInt();

        for(int i = 0; i < numberOfTestcases; i++){
            int n = input.nextInt();
            int m = input.nextInt();
            int target = input.nextInt();
    
            int[]stack1 = new int[n];
            for(int j = 0; j < n; j++){
                stack1[j] = input.nextInt();
            }
            
            int[]stack2 = new int[m];
            for(int j = 0; j < m; j++){
                stack2[j] = input.nextInt();
            }

            int result = maxMoves(target, stack1, stack2);
            System.out.println(result);
        }

        input.close();
    }

}
