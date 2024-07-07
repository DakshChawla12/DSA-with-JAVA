package Algorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithm_toGetMST {

    static class pair{
        int node;
        int distance;
        pair(int curr , int dist){
            this.node = curr;
            this.distance = dist;
        }
    }

    public static int spanningTreeSum(int V, int[][] graph) {

        // Creating an adjacency list from the given 2D array
        ArrayList<ArrayList<pair>> adjList = new ArrayList<>();
        for(int i = 0; i < V; i++){
            ArrayList<pair>temp = new ArrayList<>();
            adjList.add(temp);
        }

        for(int[]edges : graph){
            int u = edges[0];
            int v = edges[1];
            int wt = edges[2];

            adjList.get(u).add(new pair(v,wt));
            adjList.get(v).add(new pair(u,wt));
        }

        // Now you can use the adjacency list for the rest of your implementation
        PriorityQueue<pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int[] isVisited = new int[V];

        pq.add(new pair(0, 0));
        int sum = 0;

        while (!pq.isEmpty()) {
            pair p = pq.poll();
            int node = p.node;
            int wt = p.distance;

            // If the node is already visited, skip it
            if (isVisited[node] == 1) continue;

            // Mark the node as visited and add the weight to the sum
            isVisited[node] = 1;
            sum += wt;

            // Explore adjacent nodes
            for (pair neighbor : adjList.get(node)) {
                int adjNode = neighbor.node;
                int edW = neighbor.distance;
                // If the adjacent node is not visited, add it to the priority queue
                if (isVisited[adjNode] == 0) {
                    pq.offer(new pair(adjNode, edW));
                }
            }
        }
        return sum;
    }

}
