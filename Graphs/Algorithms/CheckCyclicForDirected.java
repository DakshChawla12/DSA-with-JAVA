package Algorithms;

import java.util.ArrayList;

public class CheckCyclicForDirected {

    public boolean dfs(int node , ArrayList<ArrayList<Integer>>adj , int[]isVisited , int[]pathVisited){

        isVisited[node] = 1;
        pathVisited[node] = 1;

        for(int it : adj.get(node)){
            if(isVisited[it] == 0){
                if(dfs(it,adj,isVisited,pathVisited)) return true;
            }
            else if(pathVisited[it] == 1) {
                return true;
            }
        }
        pathVisited[node] = 0;
        return false;
    }
    public boolean checkCyclic(ArrayList<ArrayList<Integer>>adj){

        int V = adj.size();
        int[]isVisited = new int[V];
        int[]pathVisited = new int[V];

        for(int i = 1; i <= V; i++){
            if(dfs(i,adj,isVisited,pathVisited)) return true;
        }
        return false;
    }

}
