package Questions;
import java.util.*;
public class ShortestPathInBinaryMatrix {

    class tuple{
        int rowIdx;
        int colIdx;
        int distance;
        tuple(int row , int col , int dist){
            this.rowIdx = row;
            this.colIdx = col;
            this.distance = dist;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        if(grid[0][0] != 0){
            return -1;
        }

        int n = grid.length;

        Queue<tuple>q = new LinkedList<>();

        q.offer(new tuple(0,0,0));


        while(!q.isEmpty()){

            tuple t = q.poll();

            int r = t.rowIdx;
            int c = t.colIdx;
            int dist = t.distance;

            if(r == n-1 && c == n-1){
                return dist;
            }

            for(int i = -1; i <= 1; i++){
                for(int j = -1; j <= 1; j++){
                    int nrow = r + i;
                    int ncol = c + j;

                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && grid[nrow][ncol] == 0){
                        q.offer(new tuple(nrow,ncol,dist+1));
                    }
                }
            }

        }
        return -1;
    }

}
