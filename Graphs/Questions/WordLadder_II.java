package Questions;
import java.util.*;
public class WordLadder_II {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String>st = new HashSet<>(wordList);

        Queue<ArrayList<String>>q = new LinkedList<>();
        ArrayList<String>ls = new ArrayList<>();
        ls.add(beginWord);
        q.offer(ls);
        ArrayList<String>usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord);

        List<List<String>>ans = new ArrayList<>();

        int level = 0;

        while(!q.isEmpty()){

            ArrayList<String>vec = q.poll();

            if(vec.size() > level){
                level++;
                for(String str : usedOnLevel){
                    st.remove(str);
                }
            }

            String word = vec.getLast();

            if(word.equals(endWord)){
                if(ans.isEmpty()) ans.add(vec);
                else if(ans.getFirst().size() == vec.size()) ans.add(vec);
            }

            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[]replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    if(st.contains(replacedWord)){
                        vec.add(replacedWord);
                        ArrayList<String>temp = new ArrayList<>(vec);
                        q.offer(temp);
                        usedOnLevel.add(replacedWord);
                        vec.removeLast();
                    }
                }
            }

        }
        return ans;
    }

}
