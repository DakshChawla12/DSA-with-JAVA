package Algorithms.ShortestPaths_algorithms;
public class FloydWarshall_algorithm {

    public void floydWarshall(int[][] graph) {

        int n = graph.length; // Number of vertices in the graph

        // Initializing the graph matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == -1) graph[i][j] = (int) 1e9; // Setting unreachable distances to a large value
                if (i == j) graph[i][j] = 0; // Setting the distance to itself to 0
            }
        }

        // Applying Floyd-Warshall algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int pathViaK = graph[i][k] + graph[k][j]; // Distance via vertex k
                    graph[i][j] = Math.min(graph[i][j], pathViaK); // Updating the shortest path if exists via vertex k
                }
            }
        }

        // Converting unreachable distances back to -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1e9) graph[i][j] = -1; // Reverting unreachable distances to -1
            }
        }
    }

}
