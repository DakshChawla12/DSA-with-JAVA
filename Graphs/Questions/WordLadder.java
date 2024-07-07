package Questions;
import java.util.*;
public class WordLadder {

    public static class pair{
        String str;
        int steps;

        pair(String s , int n){
            this.str = s;
            this.steps = n;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        //  *** If endWord is not in wordList, it's not possible to reach endWord from beginWord
        if(!wordList.contains(endWord)) return 0;

        //  ***  Queue to perform BFS traversal
        Queue<pair>q = new LinkedList<>();
        q.offer(new pair(beginWord, 1));

        //  ***  Set to efficiently check if a word is in wordList and avoid duplicates
        Set<String> st = new HashSet<>(wordList);
        st.remove(beginWord);

        while(!q.isEmpty()){

            //  ***  Current word in the ladder
            String curr = q.peek().str;
            //  ***  Number of steps to reach current word
            int steps = q.peek().steps;
            q.poll();

            //  ***  If current word matches endWord, return steps
            if(curr.equals(endWord)) return steps;

            //  ***  Generating all possible one-letter-different words
            for(int i = 0; i < curr.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){

                    char[]replacedArray = curr.toCharArray();
                    replacedArray[i] = ch;
                    String replacedWord = new String(replacedArray);

                    //  ***  If replacedWord is in wordList, add it to the queue and remove from set to avoid duplicates
                    if(st.contains(replacedWord)){
                        st.remove(replacedWord);
                        q.offer(new pair(replacedWord, steps + 1));
                    }
                }
            }
        }
        //   *** If no transformation sequence exists, return 0
        return 0;
    }


}
