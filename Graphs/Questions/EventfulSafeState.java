package Questions;
import java.util.*;
public class EventfulSafeState {

    public List<Integer> eventualSafeNodes(int[][] graph) {

        // Creating reverse adjacency list
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();

        // Initializing reverse adjacency list
        for(int i = 0; i < graph.length; i++){
            adjRev.add(new ArrayList<>());
        }

        // Calculating indegree of each node
        int[] indegree = new int[graph.length];

        // Building reverse adjacency list and calculating indegree
        for(int i = 0; i < graph.length; i++){
            for(int it : graph[i]){ // (*** outgoing edge ko incoming edge may convert krr dia)
                // Adding the reverse edge to the adjacency list.
                // The edge (it, i) signifies a reverse edge from 'it' to 'i'
                // as we are building the reverse adjacency list to trace back paths.
                adjRev.get(it).add(i);
                indegree[i]++;
            }
        }

        // Using Queue for BFS
        Queue<Integer> q = new LinkedList<>();

        // Adding nodes with indegree 0 to the queue
        for(int i = 0; i < graph.length; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        // Result list to store eventual safe nodes
        List<Integer> res = new ArrayList<>();

        // Performing BFS
        while(!q.isEmpty()){
            // Processing node
            int node = q.poll();
            res.add(node);

            // Updating indegree of adjacent nodes
            for(int it : adjRev.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    // Adding node to queue if its indegree becomes 0
                    q.offer(it);
                }
            }

        }

        // Sorting eventual safe nodes
        Collections.sort(res);
        return res;
    }


}
