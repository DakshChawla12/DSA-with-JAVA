package Algorithms;
import java.util.*;
public class BipartiteGraph {

    public boolean dfs(int node, int col, int[] color, ArrayList<ArrayList<Integer>>adj) {

        color[node] = col;

        // traverse adjacent nodes
        for(int it : adj.get(node)) {
            // if uncoloured
            if(color[it] == -1) {
                if(!dfs(it, 1 - col, color, adj)) return false;
            }
            // if previously coloured and have the same colour
            else if(color[it] == col) {
                return false;
            }
        }

        return true;
    }
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj){

        int[] color = new int[V];
        Arrays.fill(color, -1);

        for(int i = 0;i<V;i++) {
            if(color[i] == -1) {
                if(!dfs(i, 0, color, adj)) return false;
            }
        }
        return true;
    }

}
