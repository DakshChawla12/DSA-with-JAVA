package Questions;
import java.util.*;
public class CourseScheduler_I {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int n = prerequisites.length;

        // convert the graph to adjacency list
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[]indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer>q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        int cnt = 0;

        while(!q.isEmpty()){

            int node = q.poll();
            cnt++;

            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.offer(it);
                }
            }

        }
        return cnt == numCourses;
    }

}


