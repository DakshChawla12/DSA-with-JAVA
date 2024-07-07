package Algorithms.ShortestPaths_algorithms;

import  java.util.*;

public class Dijkstras_algorithm_I {

    public int[]bfs_toFindShortestPath(int[][]graph , int n , int m , int src){

        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            adj.get(graph[i][0]).add(graph[i][1]);
            adj.get(graph[i][1]).add(graph[i][0]);
        }

        int[]dist = new int[n];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;

        Queue<Integer>q = new LinkedList<>();
        q.offer(src);

        while(!q.isEmpty()){

            int node = q.poll();

            for(int it : adj.get(node)){
                if(dist[node] + 1 < dist[it]){
                    dist[it] = dist[node] + 1;
                    q.offer(it);
                }
            }

        }

        for(int i = 0; i < n; i++){
            if(dist[i] == 1e9) dist[i] = -1;
        }

        return dist;

    }

    public static void main(String[] args) {
        Dijkstras_algorithm_I obj = new Dijkstras_algorithm_I();

        int n = 5; // number of nodes
        int m = 4; // number of edges

        int[][] graph = new int[m][2];
        // Sample graph input
        graph[0][0] = 0;
        graph[0][1] = 1;
        graph[1][0] = 0;
        graph[1][1] = 2;
        graph[2][0] = 1;
        graph[2][1] = 3;
        graph[3][0] = 2;
        graph[3][1] = 4;

        int src = 0; // source node

        int[] shortestDistances = obj.bfs_toFindShortestPath(graph, n, m, src);

        System.out.println("Shortest distances from source node " + src + ":");
        for (int i = 0; i < n; i++) {
            System.out.print(shortestDistances[i] + " ");
        }
    }

}
