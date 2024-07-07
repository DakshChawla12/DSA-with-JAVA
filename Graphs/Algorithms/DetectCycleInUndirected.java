package Algorithms;
import java.util.*;


public class DetectCycleInUndirected {

    static class pair{
        int currNode;
        int parentNode;

        pair(int curr , int parent){
            this.currNode = curr;
            this.parentNode = parent;
        }
    }

//    ******************** using BFS *********************
    public boolean detect(int src , ArrayList<Integer>[]graph , int V , boolean[]isVisited){

        isVisited[src] = true;
        Queue<pair>q = new LinkedList<>();
        q.add(new pair(src, -1));

        while(!q.isEmpty()){

            int curr = q.peek().currNode;
            int parent = q.peek().parentNode;

            q.poll();

            for(int adjacentNode : graph[curr]){
                if(!isVisited[adjacentNode]){
                    isVisited[adjacentNode] = true;
                    q.add(new pair(adjacentNode, curr));
                }
                else if(adjacentNode != parent){ // If the adjacent node is visited,and it's not the parent, it indicates a cycle
                    return true;
                }
            }
        }
        return false;
    }
    public boolean hasCycle(int V , ArrayList<Integer>[]graph){

        boolean[]isVisited = new boolean[V];

        for(int i = 0; i < V; i++){
            if(detect(i,graph,V,isVisited)) return true;
        }

        return false;

    }
//    *******************************************************


//    ************** using DFS ******************************

    public boolean detectDFS(int node , int parent , ArrayList<Integer>[] graph , int[]isVisited){

        isVisited[node] = 1;
        for(int adjacent : graph[node]){
            if(isVisited[adjacent] == 0){
                if(detectDFS(adjacent, node, graph, isVisited)) return true;
            }
            else if(adjacent != parent){ // If the adjacent node is visited,and it's not the parent, it indicates a cycle
                return true;
            }
        }
        return false;
    }
    public boolean HasCycle(int V , ArrayList<Integer>[] graph){

        int[]isVisited = new int[V];
        for(int i = 0; i < V; i++){
            if(isVisited[i] == 0){
                if(detectDFS(i, -1, graph, isVisited)) return true;
            }
        }
        return false;
    }

    // Function to add an edge to the graph
    public static void addEdge(ArrayList<Integer>[] graph, int u, int v) {
        graph[u].add(v);
        graph[v].add(u);
    }

    public static void main(String[] args) {
        // Create an instance of DetectCycleInUndirected
        DetectCycleInUndirected detectCycle = new DetectCycleInUndirected();


        int V = 4; 

        ArrayList<Integer>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges to the graph
        addEdge(graph, 0, 1);
        addEdge(graph, 1, 2);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 0);

        // Check if the graph has a cycle
        boolean hasCycle = detectCycle.HasCycle(V,graph);
        boolean HasCycle = detectCycle.hasCycle(V,graph);

        // Print the result
        if (hasCycle) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }

        if (HasCycle) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }
    }

}
