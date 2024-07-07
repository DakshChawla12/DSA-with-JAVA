package Questions;

public class NumberOfEnclaves {

    public void dfs(int r , int c , int[][]arr , int[]drow , int[]dcol , int[][]isVisited){
        isVisited[r][c] = 1;

        int n = arr.length;
        int m = arr[0].length;

        for(int i = 0; i < 4; i++){
            int nrow = r + drow[i];
            int ncol = c + dcol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && isVisited[nrow][ncol] == 0 && arr[nrow][ncol] == 1){
                dfs(nrow,ncol,arr,drow,dcol,isVisited);
            }
        }
    }

    public int numEnclaves(int[][] grid) {

        int n = grid.length , m = grid[0].length;

        int[][]isVisited = new int[n][m];

        int[]drow = {0,0,1,-1};
        int[]dcol = {1,-1,0,0};

        // traversing rows
        for(int j = 0; j < m; j++){
            // first row
            if(grid[0][j] == 1 && isVisited[0][j] == 0){
                dfs(0,j,grid,drow,dcol,isVisited);
            }
            // last row
            if(grid[n-1][j] == 1 && isVisited[n-1][j] == 0){
                dfs(n-1,j,grid,drow,dcol,isVisited);
            }
        }

        // traversing rows
        for(int i = 0; i < n; i++){
            if(grid[i][0] == 1 && isVisited[i][0] == 0){
                dfs(i,0,grid,drow,dcol,isVisited);
            }
            if(grid[i][m-1] == 1 && isVisited[i][m-1] == 0){
                dfs(i,m-1,grid,drow,dcol,isVisited);
            }
        }

        int cnt = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && isVisited[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

}
