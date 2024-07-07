
public class maxKnightsIn_A_sqBoard {

    static int maxKnights = -1;
    public static boolean isSafe(char[][]grid , int r , int c){
        int n = grid.length;
        int i , j;
        // 2 up 1 right
        i = r-2;
        j = c+1;
        if(i >= 0 && j < n && grid[i][j] == 'K')  return false;
        // 2 up 1 left
        i = r-2;
        j = c-1;
        if(i >= 0 && j >= 0 && grid[i][j] == 'K') return false;
        
        // 2 down 1 right
        i = r+2;
        j = c+1;
        if(i < n && j < n && grid[i][j] == 'K')  return false;
        // 2 down 1 left
        i = r+2;
        j = c-1;
        if(i < n && j >= 0 && grid[i][j] == 'K')  return false;
        
        // 2 right 1 up
        i = r-1;
        j = c+2;
        if(i >= 0 && j < n && grid[i][j] == 'K')  return false;
        // 2 right 1 down
        i = r+1;
        j = c+2;
        if(i < n && j < n && grid[i][j] == 'K')  return false;
        // 2 left 1 up
        i = r-1;
        j = c-2;
        if(i >= 0 && j >= 0 && grid[i][j] == 'K')  return false;
        // 2 left 1 down
        i = r+1;
        j = c-2;
        if(i < n && j >= 0 && grid[i][j] == 'K')  return false;
        return true;
    }

    public static void helper(char[][]grid , int r , int c , int num){
        
        int n = grid.length;
        if(r == n){
            maxKnights = Math.max(maxKnights, num);
            return;
        }
        
        else if (isSafe(grid, r, c)){
            grid[r][c] = 'K';
            if(c != n-1) helper(grid, r, c+1, num+1);
            else helper(grid, r+1, 0, num+1);
            grid[r][c] = '.';
        }
        if(c != n-1) helper(grid, r, c+1, num);
        else helper(grid, r+1, 0, num);

    }
    public static void main(String[] args) {
        int n = 3;
        char[][]board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        helper(board, 0, 0, 0);
        System.out.println(maxKnights);
    }
}