import java.util.*;

public class KClosestToOrigin {
    
    public static class Pair {
        public int dist;
        public ArrayList<Integer> coordinates;
    
        public Pair(int dist, ArrayList<Integer> coordinates) {
            this.dist = dist;
            this.coordinates = coordinates;
        }
    }
    

    public static int helper(int a , int b){
        return (a * a) + (b * b);
    }

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.dist));
        for (int i = 0; i < points.length; i++) {
            int distance = helper(points[i][0], points[i][1]);
            Pair p = new Pair(distance, new ArrayList<>(Arrays.asList(points[i][0], points[i][1])));
            pq.offer(p);
        }
        int[][] result = new int[k][2];
        int index = 0;
        while (index < k && !pq.isEmpty()) {
            Pair pair = pq.poll();
            result[index][0] = pair.coordinates.get(0);
            result[index][1] = pair.coordinates.get(1);
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {{3, 3}, {5, -1}, {-2, 4}};
        int[][] res = kClosest(arr, 2);
    
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
