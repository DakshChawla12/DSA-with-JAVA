package Questions;
import java.util.*;

public class DistanceToNearestZero {

    public static class tuple{
        int rowIdx;
        int colIdx;
        int distance;
        tuple(int row , int col , int dist){
            this.rowIdx = row;
            this.colIdx = col;
            this.distance = dist;
        }
    }

    public static int[][] updateMatrix(int[][] mat) {
        Queue<tuple>q = new LinkedList<>();

        int n = mat.length;
        int m = mat[0].length;

        int[][]res = new int[n][m];
        boolean[][]isVisited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    q.offer(new tuple(i,j,0));
                    isVisited[i][j] = true;
                }
            }
        }

        int[]drow = {1,0,-1,0};
        int[]dcol = {0,1,0,-1};

        while(!q.isEmpty()){

            int r = q.peek().rowIdx;
            int c = q.peek().colIdx;
            int d = q.peek().distance;

            res[r][c] = d;

            q.poll();

            for(int i = 0; i < 4; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !isVisited[nrow][ncol]){
                    isVisited[nrow][ncol] = true;
                    q.offer(new tuple(nrow , ncol , d+1));
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {

        int[][]arr = {{0,0,0},{0,1,0},{1,1,1}};
        int[][]res = updateMatrix(arr);

        for (int[] re : res) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(re[j] + " ");
            }
            System.out.println();
        }
    }

}
