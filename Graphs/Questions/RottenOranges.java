package Questions;
import java.util.*;
public class RottenOranges {

    public class tuple{
        int rowIdx;
        int colIdx;
        int time;

        tuple(int r , int c , int tm){
            this.rowIdx = r;
            this.colIdx = c;
            this.time = tm;
        }
    }
    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<tuple>q = new LinkedList<>();

        int[][]isVisited = new int[n][m];
        int countFresh = 0;

        // Initialize queue and count fresh oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new tuple(i, j, 0)); // Add rotten oranges to queue
                    isVisited[i][j] = 2; // Mark as visited
                } else {
                    isVisited[i][j] = 0; // Mark as unvisited
                }
                if (grid[i][j] == 1)
                    countFresh++; // Count fresh oranges
            }
        }

        int tm = 0;
        int[]dRow = {-1,0,1,0};
        int[]dCol = {0,1,0,-1};
        int cnt = 0;

        while(!q.isEmpty()){ // BFS to rot oranges
            int r = q.peek().rowIdx;
            int c = q.peek().colIdx;
            int t = q.peek().time;

            tm = Math.max(tm,t); // Update time

            q.poll();
            // Check if adjacent cell is valid and fresh
            for(int i = 0; i < 4; i++){
                int nrow = r + dRow[i];
                int ncol = c + dCol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && isVisited[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    q.offer(new tuple(nrow,ncol,t+1)); // Add to queue
                    isVisited[nrow][ncol] = 2; // Mark as visited
                    cnt ++; // Increment count of rotten oranges
                }
            }
        }

        if(cnt != countFresh) return -1;
        return tm;

    }

}
