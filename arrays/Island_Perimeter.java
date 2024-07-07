public class Island_Perimeter {
    
    public int islandPerimeter(int[][]grid) {

            int perimeter = 0;
            int rows = grid.length;
            int cols = grid[0].length;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 1) {
                         perimeter += 4; // Each cell contributes 4 to the perimeter
    
                         // Check neighbors and deduct shared sides
                         if (i > 0 && grid[i - 1][j] == 1) perimeter -= 2; // Up neighbor
                         if (j > 0 && grid[i][j - 1] == 1) perimeter -= 2; // Left neighbor
                    }
                }
            }
            return perimeter;
    }
}
