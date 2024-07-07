package Questions;

import java.util.PriorityQueue;

public class PathWithMinEffort {

    class tuple{
        int rowIdx;
        int colIdx;
        int distance;
        tuple(int r , int c , int dist){
            this.rowIdx = r;
            this.colIdx = c;
            this.distance = dist;
        }
    }


    public int minimumEffortPath(int[][] heights) {

        PriorityQueue<tuple>pq = new PriorityQueue<>((x,y) -> x.distance-y.distance);
        int n = heights.length , m = heights[0].length;

        int[][]distance = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                distance[i][j] = (int)1e9;
            }
        }

        distance[0][0] = 0;
        pq.offer(new tuple(0,0,0));

        int[]drow = {1,-1,0,0};
        int[]dcol = {0,0,1,-1};

        while(!pq.isEmpty()){

            tuple t = pq.poll();
            int r = t.rowIdx;
            int c = t.colIdx;
            int diff = t.distance;

            if(r == n-1 && c == m-1) return diff;

            for(int i = 0; i < 4; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if(nrow >=0 && nrow < n && ncol >= 0 && ncol < m){
                    int newEffort = Math.max(Math.abs(heights[r][c] - heights[nrow][ncol]),diff);
                    if(newEffort < distance[nrow][ncol]){
                        distance[nrow][ncol] = newEffort;
                        pq.offer(new tuple(nrow,ncol,newEffort));
                    }
                }
            }

        }
        return 0;
    }

}
