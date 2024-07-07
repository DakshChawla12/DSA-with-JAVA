package Questions;

public class FindTheCityWithTheSmallestNumberOfNeighborsTtAThresholdDistance {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int m = edges.length;
        int[][] dist = new int[n][n];

        // Filling the distance matrix with maximum values
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        // Assigning weights to edges in the graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        // Initializing diagonal elements of the distance matrix to 0
        for(int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }

        // Applying Floyd Warshall algorithm to find the shortest distances between all pairs of vertices
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    int pathViaK = dist[i][k] + dist[k][j]; // Distance via vertex k
                    dist[i][j] = Math.min(dist[i][j], pathViaK); // Updating the shortest path if exists via vertex k
                }
            }
        }

        // Finding the city with the minimum number of reachable cities within the distance threshold
        int minCount = n;
        int cityIdx = -1;

        for(int i = 0; i < n; i++) {
            int cnt = 0;
            for(int j = 0; j < n; j++) {
                if(dist[i][j] <= distanceThreshold) cnt++;
            }
            if(cnt <= minCount) {
                minCount = cnt;
                cityIdx = i;
            }
        }
        return cityIdx;
    }


}
