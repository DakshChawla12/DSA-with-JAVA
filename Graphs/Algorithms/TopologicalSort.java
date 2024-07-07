package Algorithms;

import java.util.*;
public class TopologicalSort {

    public static void dfs(int node , ArrayList<ArrayList<Integer>>adj , Stack<Integer>st , int[]isVisited){

        isVisited[node] = 1;

        for(int it : adj.get(node)){
            if(isVisited[it] == 0){
                dfs(it,adj,st,isVisited);
            }
        }
        st.push(node);
    }
    public static void getTopologicalOrder(int V , ArrayList<ArrayList<Integer>>adj){

        int[]isVisited = new int[V];
        Stack<Integer>st = new Stack<>();

        for(int i = 0; i < V; i++){
            if(isVisited[i] == 0){
                dfs(i,adj,st,isVisited);
            }
        }
        while(!st.isEmpty()){
            System.out.print(st.pop() + " ");
        }
    }

    // ****** Kahn's Algorithm ******
    public static void getTopologicalOrder_BFS(int V , ArrayList<ArrayList<Integer>>adj){

        int[]indegree = new int[V];

        for(int i = 0; i < V; i++){  // *** making the indegree array ***
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer>q = new LinkedList<>();

        for(int i = 0; i < V; i++){  // *** adding all the elements with indegree 0 to the queue
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        ArrayList<Integer>ls = new ArrayList<>();

        while(!q.isEmpty()){

            int node = q.poll();

            ls.add(node); // adding the front element as its indegree will be 0,so it will be in topological order

            for(int it : adj.get(node)){
                indegree[it]--; // reducing the degrees for all the nodes having incoming edges from current node
                if(indegree[it] == 0){ // if after reducing the degree,it becomes 0 add it to the queue
                    q.add(it);
                }
            }

        }
        System.out.println(ls);
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }

    public static void main(String[] args) {

        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges
        addEdge(adj, 5, 2);
        addEdge(adj, 5, 0);
        addEdge(adj, 4, 0);
        addEdge(adj, 4, 1);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 1);

        System.out.println("Topological order of the graph:");
        getTopologicalOrder(V,adj);
    }



}


