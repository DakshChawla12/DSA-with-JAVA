import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;


public class Group_anagram {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        // Create a HashMap to store groups of anagrams
        Map<String, List<String>> map = new HashMap<>();
        
        // Iterate through each word in the input array
        for (String word : strs) {
            // Convert the word to a character array
            char[] chars = word.toCharArray();
            
            // Sort the characters in the word
            Arrays.sort(chars);
            
            // Create a string from the sorted characters
            String sortedWord = new String(chars);
            
            // If the sorted word is not a key in the map, add it with an empty list
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            
            // Add the original word to the list associated with its sorted version
            map.get(sortedWord).add(word);
        }
        
        // Return a list containing all the lists of anagrams
        return new ArrayList<>(map.values());
    }
}


