package Questions;

import java.util.LinkedList;
import java.util.Queue;

public class CountIslands {

    public static class pair{
        int rowIdx;
        int colIdx;

        pair(int r , int c){
            this.rowIdx = r;
            this.colIdx = c;
        }
    }

    public void bfs(int row , int col , int[][]arr , int[][]isVisited){

        isVisited[row][col] = 1;
        Queue<pair>q = new LinkedList<>();
        q.offer(new pair(row, col));

        int n = arr.length , m = arr[0].length;

        while(!q.isEmpty()){

            int r = q.peek().rowIdx;
            int c = q.peek().colIdx;

            q.poll();

            for(int i = -1; i <= 1; i++){
                for(int j = -1; j <= 1; j++){

                    int nrow = r + i;
                    int ncol = c + j;

                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && arr[nrow][ncol] == 1 && isVisited[nrow][ncol] == 0){
                        isVisited[nrow][ncol] = 1;
                        q.offer(new pair(nrow, ncol));
                    }

                }
            }

        }

    }
    public int totalIslands(int[][]arr){

        int n = arr.length , m = arr[0].length;
        int[][]isVisited = new int[n][m];
        int cnt = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] == 1 && isVisited[i][j] == 0){
                    bfs(i,j,arr,isVisited);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

        int[][]arr = {{0,1,1,1,0,0,0} , {0,0,1,1,0,1,0}};
        CountIslands obj = new CountIslands();
        System.out.println(obj.totalIslands(arr));

    }

}
