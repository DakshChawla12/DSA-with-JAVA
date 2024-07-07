package Questions;
import java.util.*;
public class CourseScheduler_II {

    public int[] findOrder(int V, int[][] prerequisites) {

        int n = prerequisites.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Create adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Populate adjacency list with prerequisites
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }

        int[] indegree = new int[V];

        // Calculate indegree of each course
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // Enqueue courses with indegree 0
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] res = new int[V];
        int idx = 0;

        // Perform topological sorting
        while (!q.isEmpty()) {
            int node = q.poll();
            res[idx++] = node;

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.offer(it);
                }
            }
        }

        // Check if all courses have been taken
        if (idx == V) return res;
        return new int[]{};
    }

}
