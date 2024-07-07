

public class trappedRainwater {

    /*
        Steps -->
        1) calculate the leftmax array
        2) calculate the rightmax array

        **loop
        water level (for current bar) = min(leftmax,rightmax)
        trapped water =waterLevel-bar height
     */


    public static int Trapped_Rainwater(int height[]) {

        int n = height.length;
    
        // Initialize an array to store the maximum height to the left of each element
        int leftMax[] = new int[n];
        leftMax[0] = height[0]; // First element has no elements to its left
    
        // Calculate the maximum height to the left for each element
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
    
        // Initialize an array to store the maximum height to the right of each element
        int rightmax[] = new int[n];
        rightmax[n - 1] = height[n - 1]; // Last element has no elements to its right
    
        // Calculate the maximum height to the right for each element
        for (int i = n - 2; i >= 0; i--) {
            rightmax[i] = Math.max(height[i], rightmax[i + 1]);
        }
    
        // Initialize a variable to store the total trapped rainwater
        int waterTrapped = 0;
    
        // Calculate the trapped rainwater for each element and accumulate the total
        for (int i = 0; i < n; i++) {
            // The water level is the minimum of the maximum heights to the left and right
            int waterLevel = Math.min(leftMax[i], rightmax[i]);
            // The trapped water for the current element is the difference between the water level and the current height
            waterTrapped += waterLevel - height[i];
        }
    
        // Return the total trapped rainwater
        return waterTrapped;
    }
    

    public static void main(String[] args) {
        int arr[] = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(Trapped_Rainwater(arr));
    }
    
}