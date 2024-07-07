package Algorithms;
import  java.util.*;

public class DetectCycleUsingBfs {

    public static boolean detectCycle(int V , int[][]graph){

        int[]indegree = new int[V];

        for(int i = 0; i < V; i++){
            for(int it : graph[i]){
                indegree[it]++;
            }
        }

        Queue<Integer>q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        int cnt = 0;

        while(!q.isEmpty()){

            int node = q.poll();
            cnt++;

            for(int it : graph[node]){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.offer(it);
                }
            }

        }
        return cnt == V;
    }

    public static void main(String[] args) {
        // Example graph represented as adjacency list
        int[][] graph = {
                {1},        // Node 0 points to Node 1
                {2},        // Node 1 points to Node 2
                {3},        // Node 2 points to Node 3
                {4},        // Node 3 points to Node 4
                {1}         // Node 4 points back to Node 1 (creating a cycle)
        };

        int numNodes = graph.length;

        boolean hasCycle = detectCycle(numNodes, graph);

        if (!hasCycle) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph is acyclic.");
        }
    }

}
