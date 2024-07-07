import java.util.*;

public class countSubarrayWithXOR_K {
    
    public static int countXOR(int[] arr, int k) {
        int n = arr.length;
        HashMap<Integer, Integer> mpp = new HashMap<>(); // HashMap to store XOR values and their counts

        int XR = 0; // Cumulative XOR of elements encountered
        int count = 0; // Counter for subarrays with XOR equal to k
        mpp.put(0, 1); // Initialize the HashMap with XOR 0 encountered once

        for (int i = 0; i < n; i++) {
            XR = XR ^ arr[i];  // prefix XOR till index i:
            int x = XR ^ k; // Calculate the XOR required to reach k (By formula: x = xr^k)

            // if map contains a key x add its corresponding value to count
            if (mpp.containsKey(x)) {
                count += mpp.get(x);
            }

            // Update the HashMap with the frequency of the current XOR value

            if (mpp.containsKey(XR)) { // increase its count by one if it already exists
                mpp.put(XR, mpp.get(XR) + 1);
            } else {
                mpp.put(XR, 1); // Initialize the count if encountering the XOR for the first time
            }
        }
        return count; 
    }

}
