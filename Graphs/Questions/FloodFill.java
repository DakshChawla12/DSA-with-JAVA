package Questions;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    static class pair{
        int rowIdx;
        int colIdx;

        pair(int r , int c){
            this.rowIdx = r;
            this.colIdx = c;
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if(image[sr][sc] == color) return image;

        int n = image.length;
        int m = image[0].length;

        Queue<pair>q = new LinkedList<>();
        q.offer(new pair(sr, sc));

        int[]dRow = {-1,0,1,0};
        int[]dCol = {0,-1,0,1};

        int x = image[sr][sc];

        while(!q.isEmpty()){

            int r = q.peek().rowIdx;
            int c = q.peek().colIdx;

            q.poll();

            for(int i = 0; i < 4; i++){
                int nrow = r + dRow[i];
                int ncol = c + dCol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == x){
                    image[nrow][ncol] = color;
                    q.offer(new pair(nrow, ncol));
                }
            }
        }
        image[sr][sc] = color;
        return image;

    }

    public static void main(String[] args) {
//        [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
          int[][]arr = {{1,1,1},{1,1,0},{1,0,1}};

          int[][]res = floodFill(arr,1,1,2);

          for(int i = 0; i < res.length; i++){
              for(int j = 0; j < res[0].length; j++){
                  System.out.print(res[i][j] + " ");
              }
              System.out.println();
          }

    }

}
