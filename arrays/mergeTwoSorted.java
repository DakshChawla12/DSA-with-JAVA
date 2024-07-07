import java.util.*;       /// without any extra space///

public class mergeTwoSorted {

    public void approach_One(int[]arr1 , int[]arr2 , int n , int m){  // approach 1

        // total T.C = O(min(n,m)) + O(nlogn) + O(mlogm)

        int left = n-1 , right = 0;

        while(left >= 0 && right < m){
            if(arr1[left] > arr2[right]){
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;right++;
            }
            else{
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
    
}