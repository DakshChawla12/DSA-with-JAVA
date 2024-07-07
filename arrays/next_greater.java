import java.util.*;

public class next_greater {
    
    public static int[] Next_Greater(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
    
        ArrayList<Integer> ls = new ArrayList<>();
    
        for (int i = 0; i < n; i++) {
            int ele1 = arr1[i];
            int j = 0;
            int ele2 = -1;
    
            // Find the index of ele1 in arr2
            while (j < m && arr2[j] != ele1) {
                j++;
            }
    
            // Check if ele1 was found in arr2
            if (j < m) {
                // Move to the next greater element in arr2
                while (j < m && arr2[j] <= ele1) {
                    j++;
                }
    
                // If a greater element exists, assign it to ele2
                if (j < m) {
                    ele2 = arr2[j];
                }
            }
    
            ls.add(ele2);
        }
        int k = 0;
        int[]res = new int[ls.size()];
    
        for(int x : ls){
            res[k] = x;
            k++;
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[]arr1 = new int[]{2,4};
        int[]arr2 = new int[]{1,2,3,4};

        int[]res = Next_Greater(arr1, arr2);

        for(int x : res){
            System.out.print(x+" ");
        }
    }
}
