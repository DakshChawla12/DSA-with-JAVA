package Algorithms.ShortestPaths_algorithms;

import java.util.*;

public class BellmanFord_algorithm {

    public int[] bellmanFord(int V , int src , ArrayList<ArrayList<Integer>>adj){

        int[]dist = new int[V];
        Arrays.fill(dist,(int)1e8);
        dist[src] = 0;

        // V x E
        for(int i = 0; i < V-1; i++){  // *** doing the relaxation process n-1 times
            for(ArrayList<Integer>it : adj){
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);

                if(dist[u] != 1e8 && dist[u]+wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }
        // *** Nth relaxation to check for negative cycle
        for(ArrayList<Integer>it : adj){
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            // *** if negative cycle exists after n-1 iterations return the temp array
            if(dist[u] != 1e8 && dist[u]+wt < dist[v]){
                int[]temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
        return dist;
    }

}
