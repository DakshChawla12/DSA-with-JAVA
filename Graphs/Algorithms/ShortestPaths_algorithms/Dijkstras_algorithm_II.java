package Algorithms.ShortestPaths_algorithms;

import java.util.*;
public class Dijkstras_algorithm_II {

    static class pair{
        int destination;
        int weight;
        pair(int dest , int wt){
            this.destination = dest;
            this.weight = wt;
        }
    }

    public static void getTopo(int node , ArrayList<ArrayList<pair>>adj , int[]visited , Stack<Integer>st){

        visited[node] = 1;

        for(int i = 0; i < adj.get(node).size(); i++){
            int v = adj.get(node).get(i).destination;
            if(visited[v] == 0){
                getTopo(v,adj,visited,st);
            }
        }
        st.push(node);
    }
    public static int[] shortestPathInDAG(int n, int m, int [][]graph) {

       ArrayList<ArrayList<pair>>adj = new ArrayList<>();

       for(int i = 0; i < m; i++){
           ArrayList<pair>ls = new ArrayList<>();
           adj.add(ls);
       }

       for(int i = 0; i < m; i++){
           int u = graph[i][0]; // src node
           int v = graph[i][1]; // destination node
           int wt = graph[i][2]; // weight of the edge

           adj.get(u).add(new pair(v, wt));
       }
       int[]visited = new int[n];
       Stack<Integer>st = new Stack<>();

       for(int i = 0; i < n; i++){ // get the topological sort
           if(visited[i] == 0){
               getTopo(i,adj,visited,st);
           }
       }

       int[]dist = new int[n];
       Arrays.fill(dist, (int) 1e9);
       dist[0] = 0;

       while(!st.isEmpty()){

           int node = st.pop();

           for(int i = 0; i < adj.get(node).size(); i++){
               int v = adj.get(node).get(i).destination;
               int wt = adj.get(node).get(i).weight;

               if(dist[node] + wt < dist[v]){
                   dist[v] = dist[node] + wt;
               }
           }

       }

       for(int i = 0; i < n; i++){
           if(dist[i] == 1e9) dist[i] = -1;
       }
       return dist;
    }

}
