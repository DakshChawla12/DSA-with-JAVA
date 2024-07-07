package Questions;
import java.util.*;
public class NumberOfWaysToArrivedestination {

    static class pair{
        int node;
        int distance;
        pair(int curr , int dist){
            this.node = curr;
            this.distance = dist;
        }
    }

    public static int countPaths(int n, int[][] roads) {

        ArrayList<ArrayList<pair>>adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            ArrayList<pair>temp = new ArrayList<>();
            adj.add(temp);
        }

        for (int[] road : roads) {
            int s = road[0];
            int d = road[1];
            int wt = road[2];

            adj.get(s).add(new pair(d, wt));
            adj.get(d).add(new pair(s, wt));
        }

        int[]distance = new int[n];
        int[]ways = new int[n];
        Arrays.fill(distance,(int)1e9);
        Arrays.fill(ways,0);

        distance[0] = 0;
        ways[0] = 1;

        PriorityQueue < pair > pq = new PriorityQueue < pair > ((x, y) -> x.distance - y.distance);
        pq.offer(new pair(0, 0));

        int mod = (int)1e9;

        while(!pq.isEmpty()){

            pair p = pq.poll();
            int node = p.node;
            int d = p.distance;

            for(pair it : adj.get(node)){
                int curr = it.node;
                int dist = it.distance;
                if(dist + d < distance[curr]){
                    distance[curr] = dist + d;
                    pq.offer(new pair(curr,dist+d));
                    ways[curr] = ways[node];
                }
                else if(dist + d == distance[curr]){
                    ways[curr] = ways[curr] + ways[node]%mod;
                }
            }

        }
        return ways[n-1] % mod;
    }

        public static void main(String[] args) {
            int n = 7;
            int[][] roads = {{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}};
            System.out.println(countPaths(n,roads));

        }

}
