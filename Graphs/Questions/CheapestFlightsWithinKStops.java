package Questions;
import java.util.*;

public class CheapestFlightsWithinKStops {

    static class pair {
        int node;
        int price;

        pair(int curr, int cost) {
            this.node = curr;
            this.price = cost;
        }
    }

    static class tuple {
        int stops;
        int node;
        int distance;

        tuple(int s, int n, int dist) {
            this.stops = s;
            this.node = n;
            this.distance = dist;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int m = flights.length;
        for (int i = 0; i < m; i++) {
            adj.get(flights[i][0]).add(new pair(flights[i][1], flights[i][2]));
        }

        Queue<tuple> pq = new LinkedList<>();
        pq.offer(new tuple(0, src, 0));

        int[] cheapestPrice = new int[n];
        Arrays.fill(cheapestPrice, Integer.MAX_VALUE);
        cheapestPrice[src] = 0;

        while (!pq.isEmpty()) {
            tuple t = pq.poll();
            int stops = t.stops;
            int node = t.node;
            int cost = t.distance;

            if (node == dst) {
                continue;
            }

            if (stops > k) {
                continue;
            }

            for (pair it : adj.get(node)) {
                int curr = it.node;
                int fare = it.price;

                if (cost + fare < cheapestPrice[curr]) {
                    pq.offer(new tuple(stops + 1, curr, cost + fare));
                    cheapestPrice[curr] = cost + fare;
                }
            }
        }

        if(cheapestPrice[dst] != Integer.MAX_VALUE) return cheapestPrice[dst];
        return -1;
    }
    
}
