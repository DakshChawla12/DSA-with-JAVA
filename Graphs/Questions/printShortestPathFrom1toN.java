package Questions;
import java.util.*;

public class printShortestPathFrom1toN {

    static class pair {
        int node;
        int distance;

        pair(int curr, int dist) {
            this.node = curr;
            this.distance = dist;
        }
    }

    public ArrayList<Integer> getShortestPath(int n, int m, int[][] graph) {

        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            ArrayList<pair> temp = new ArrayList<>();
            adj.add(temp);
        }
        for (int i = 0; i < m; i++) {
            adj.get(graph[i][0]).add(new pair(graph[i][1], graph[i][2]));
            adj.get(graph[i][1]).add(new pair(graph[i][0], graph[i][2]));
        }

        int[] parent = new int[n + 1];
        int[] dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            dist[i] = Integer.MAX_VALUE;
        }
        dist[1] = 0;

        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.offer(new pair(1, 0));

        while (!pq.isEmpty()) {

            pair it = pq.poll();
            int node = it.node;
            int dis = it.distance;

            for (pair p : adj.get(node)) {
                int adjNode = p.node;
                int edW = p.distance;

                if (dis + edW < dist[adjNode]) {
                    dist[adjNode] = dis + edW;
                    parent[adjNode] = node;
                    pq.offer(new pair(adjNode, dis + edW));
                }
            }

        }

        ArrayList<Integer> res = new ArrayList<>();
        if (dist[n] == Integer.MAX_VALUE) {
            res.add(-1);
            return res;
        }

        int temp = n;
        while (parent[temp] != temp) {
            res.add(temp);
            temp = parent[temp];
        }
        res.add(1);
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        printShortestPathFrom1toN shortestPathFinder = new printShortestPathFrom1toN();

        // Example graph represented as an adjacency matrix
        int[][] graph = {
                {1, 2, 1}, // Edge from node 1 to node 2 with weight 1
                {1, 3, 4}, // Edge from node 1 to node 3 with weight 4
                {2, 3, 2}, // Edge from node 2 to node 3 with weight 2
                {2, 4, 5}, // Edge from node 2 to node 4 with weight 5
                {3, 4, 1}  // Edge from node 3 to node 4 with weight 1
        };

        int n = 4; // Number of nodes
        int m = 5; // Number of edges

        ArrayList<Integer> shortestPath = shortestPathFinder.getShortestPath(n, m, graph);

        System.out.println("Shortest Path from Node 1 to Node " + n + ":");
        if (shortestPath.get(0) == -1) {
            System.out.println("No path exists.");
        } else {
            for (int node : shortestPath) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }
}
