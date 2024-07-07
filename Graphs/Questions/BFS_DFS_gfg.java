package Questions;
import  java.util.*;
public class BFS_DFS_gfg {

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> arr) {

        ArrayList<Integer>res = new ArrayList<>();

        boolean[]isVisited = new boolean[V];
        Queue<Integer>q = new LinkedList<>();
        q.offer(0);

        while(!q.isEmpty()){
            int curr = q.poll();

            if(!isVisited[curr]){
                res.add(curr);
                isVisited[curr] = true;

                for (Integer it : arr.get(curr)) {
                    q.add(it);
                }
            }

        }

        return res;
    }

    public static void DFS_traversal(ArrayList<ArrayList<Integer>> adj , int curr , boolean[]isVisited , ArrayList<Integer>ls){

        if(isVisited[curr]) return;

        ls.add(curr);
        isVisited[curr] = true;

        for(Integer it: adj.get(curr)) {
            DFS_traversal(adj, it, isVisited, ls);
        }

    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer>ls = new ArrayList<>();
        boolean[]isVisited = new boolean[V];
        DFS_traversal(adj,0,isVisited,ls);
        return ls;
    }

}
