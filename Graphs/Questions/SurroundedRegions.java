package Questions;

/*
APPROACH -->
Depth-First Search (DFS): You used DFS to traverse the grid starting from boundary cells that contain 'O's.
DFS is a recursive algorithm that traverses as far as possible along each branch before backtracking.

Boundary Traversal: You traversed the boundary cells of the grid and applied DFS to explore connected regions of 'O's.

Marking Visited Cells: You marked visited cells to avoid revisiting them during DFS traversal.

Conditional Checks: During traversal, you checked conditions to ensure that you're exploring only 'O' cells and within the grid boundaries.

Marking Surrounded Regions: After DFS traversal, you marked regions of 'O's that are not surrounded by 'X's.

Conversion: Finally, you converted the surrounded regions to 'X's, as they are not part of any surrounded region.
* */
public class SurroundedRegions {

    public void dfs(int r , int c , char[][]board , int[]drow , int[]dcol , int[][]isVisited){
        isVisited[r][c] = 1;

        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i < 4; i++){
            int nrow = r + drow[i];
            int ncol = c + dcol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && isVisited[nrow][ncol] == 0 && board[nrow][ncol] == 'O'){
                dfs(nrow,ncol,board,drow,dcol,isVisited);
            }
        }
    }
    public void solve(char[][] board) {

        int n = board.length , m = board[0].length;

        int[][]isVisited = new int[n][m];

        int[]drow = {1,0,-1,0};
        int[]dcol = {0,1,0,-1};

        // traversing rows
        for(int j = 0; j < m; j++){
            // first row
            if(board[0][j] == 'O' && isVisited[0][j] == 0){
                dfs(0,j,board,drow,dcol,isVisited);
            }
            // last row
            if(board[n-1][j] == 'O' && isVisited[n-1][j] == 0){
                dfs(n-1,j,board,drow,dcol,isVisited);
            }
        }

        // traversing rows
        for(int i = 0; i < n; i++){
            if(board[i][0] == 'O' && isVisited[i][0] == 0){
                dfs(i,0,board,drow,dcol,isVisited);
            }
            if(board[i][m-1] == 'O' && isVisited[i][m-1] == 0){
                dfs(i,m-1,board,drow,dcol,isVisited);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O' && isVisited[i][j] == 0){
                    board[i][j] = 'X';
                }
            }
        }

    }

}
