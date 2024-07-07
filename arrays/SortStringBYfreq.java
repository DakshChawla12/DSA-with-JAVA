import java.util.*;

public class SortStringBYfreq {
    public void reverse(int[] arr, int s, int e) {
        while (s <= e) {
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }

public String frequencySort(String s) {
    int n = s.length();
    HashMap<Character, Integer> mpp = new HashMap<>();

    // Count frequencies of characters
    for (int i = 0; i < n; i++) {
        char ch = s.charAt(i);
        mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);
    }

    // Store frequencies in an array
    int[] arr = new int[n]; // Size should be n, not n+1
    int k = 0;

    for (char x : mpp.keySet()) {
        int cnt = mpp.get(x);
        arr[k] = cnt;
        k++;
    }

    Arrays.sort(arr); // Sort the frequency array
    reverse(arr, 0, arr.length - 1); // Reverse the sorted array

    StringBuilder sortedString = new StringBuilder();

    // Reconstruct string based on sorted frequencies
    for (int i = 0; i < arr.length; i++) {
        int freq = arr[i];
        for (char ch : mpp.keySet()) {
            if (mpp.get(ch) == freq) {
                for (int j = 0; j < freq; j++) {
                    sortedString.append(ch);
                }
                mpp.remove(ch); // To handle duplicate frequencies
                    break;
            }
        }
    }

    return sortedString.toString();
}
}
