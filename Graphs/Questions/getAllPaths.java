package Questions;

import java.util.*;

public class getAllPaths {

    public void dfs(int node , int[][]graph ,int[]isVisited , List<List<Integer>>ls , ArrayList<Integer>ds){

        ds.add(node);

        if(node == graph.length-1){
            ls.add(new ArrayList<>(ds));
            return;
        }
        isVisited[node] = 1;

        for(int it : graph[node]){
            if(isVisited[it] == 0){
                dfs(it,graph,isVisited,ls,ds);
                ds.removeLast();
            }
        }
        isVisited[node] = 0;
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        int V = graph.length;
        int[]isVisited = new int[V];

        List<List<Integer>>ls = new ArrayList<>();

        dfs(0,graph,isVisited,ls,new ArrayList<>());

        return ls;

    }

}
