package Questions;
import java.util.*;
public class countProvinces {

    public void dfs(ArrayList<Integer>[]graph , int node , boolean[]isVisited){
        if(isVisited[node]) return;
        isVisited[node] = true;

        for(int i = 0; i < graph[node].size(); i++){
            dfs(graph,graph[node].get(i),isVisited);
        }
    }

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        ArrayList<Integer>[]graph = new ArrayList[n]; // ** creating a new ArrayList at every index
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<Integer>();
        }

        // to convert the adjacency matrix into adjacency list
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Check if there is an edge between nodes i and j, and ensure they are not the same node
                if (isConnected[i][j] == 1 && i != j) {
                    // Add j to the adjacency list of node i
                    graph[i].add(j);
                    // Add i to the adjacency list of node j (since the graph is undirected)
                    graph[j].add(i);
                }
            }
        }

        boolean[] isVisited = new boolean[n];
        int cnt = 0;

        // *** DFS for disconnected graph
        for (int i = 0; i < n; i++) {
            // Check if the current node has not been visited yet
            if (!isVisited[i]) {
                // Increment the count of connected components
                cnt++;
                // Perform DFS starting from the unvisited node
                dfs(graph, i, isVisited);
            }
        }

        return cnt;

    }

}
