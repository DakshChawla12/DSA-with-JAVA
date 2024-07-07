package Questions;
import java.util.*;

public class NetworkDelayTime {

    static class pair {
        int node;
        int time;

        pair(int curr, int t) {
            this.node = curr;
            this.time = t;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<pair>>adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            ArrayList<pair>temp = new ArrayList<>();
            adj.add(temp);
        }

        for (int[] edge : times) {
            int sourceNode = edge[0];
            int targetNode = edge[1];
            int time = edge[2];
            adj.get(sourceNode).add(new pair(targetNode, time));
        }

        int[]timeTaken = new int[n+1];
        Arrays.fill(timeTaken,Integer.MAX_VALUE);
        timeTaken[k] = 0;

        Queue<pair>q = new LinkedList<>();
        q.offer(new pair(k,0));

        while(!q.isEmpty()){

            pair p = q.poll();
            int node = p.node;
            int t = p.time;

            for(pair it : adj.get(node)){
                int curr = it.node;
                int time = it.time;

                if(time + t < timeTaken[curr]){
                    timeTaken[curr] = time + t;
                    q.offer(new pair(curr,time+t));
                }

            }

        }
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, timeTaken[i]);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

}
