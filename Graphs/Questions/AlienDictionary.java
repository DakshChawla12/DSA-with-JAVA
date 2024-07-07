package Questions;
import java.util.*;
public class AlienDictionary {

    public List<Integer>topoSort(int V , ArrayList<ArrayList<Integer>>adj){

        int[]indegree = new int[V];
        for(int i = 0; i < V; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer>q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        List<Integer>res = new ArrayList<>();

        while(!q.isEmpty()){

            int node = q.poll();
            res.add(node);

            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.offer(it);
                }
            }

        }
        return res;
    }

    public String findOrder(int n , int k , String[]dict){

        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();

        for(int i = 0; i < k; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < dict.length-1; i++){
            String a = dict[i];
            String b = dict[i+1];
            int len = Math.min(a.length(),b.length());
            for(int it = 0; it < len; it++){
                if(a.charAt(it) != b.charAt(it)){
                    adj.get(a.charAt(it) - 'a').add(b.charAt(it) - 'a');
                    break;
                }
            }
        }

        List<Integer>ls = topoSort(k,adj);
        String ans = "";
        for(int it : ls){
            ans = ans + (char)(it + (int)('a'));
        }
        return ans;
    }

    public static void main(String[] args) {
        int N = 5, K = 5;
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};

        AlienDictionary obj = new AlienDictionary();
        String ans = obj.findOrder(N,K,dict);

        System.out.println(ans);

    }

}
