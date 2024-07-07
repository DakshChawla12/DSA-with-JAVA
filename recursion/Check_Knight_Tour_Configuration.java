
public class Check_Knight_Tour_Configuration {
    
    public boolean helper(int[][]grid , int r , int c , int num) {

        int n = grid.length;
        if(num == (n*n)-1) return true;
        int i , j;
        // 2 up 1 right
        i = r-2;
        j = c+1;
        if(i >= 0 && j < n && grid[i][j] == num+1) return helper(grid,i,j,num+1);
        // 2 up 1 left
        i = r-2;
        j = c-1;
        if(i >= 0 && j >= 0 && grid[i][j] == num+1) return helper(grid,i,j,num+1);
        
        // 2 down 1 right
        i = r+2;
        j = c+1;
        if(i < n && j < n && grid[i][j] == num+1) return helper(grid,i,j,num+1);
        // 2 down 1 left
        i = r+2;
        j = c-1;
        if(i < n && j >= 0 && grid[i][j] == num+1) return helper(grid,i,j,num+1);
        
        // 2 right 1 up
        i = r-1;
        j = c+2;
        if(i >= 0 && j < n && grid[i][j] == num+1) return helper(grid,i,j,num+1);
        // 2 right 1 down
        i = r+1;
        j = c+2;
        if(i < n && j < n && grid[i][j] == num+1) return helper(grid,i,j,num+1);

        // 2 left 1 up
        i = r-1;
        j = c-2;
        if(i >= 0 && j >= 0 && grid[i][j] == num+1) return helper(grid,i,j,num+1);
        // 2 left 1 down
        i = r+1;
        j = c-2;
        if(i < n && j >= 0 && grid[i][j] == num+1) return helper(grid,i,j,num+1);
        return false;
    }

    public boolean checkValidGrid(int[][] grid) {
        if(grid[0][0] != 0) return false;
        return helper(grid,0,0,0);
    }

}
