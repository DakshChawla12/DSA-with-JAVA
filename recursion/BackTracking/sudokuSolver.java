
public class sudokuSolver {

    public boolean isValid(char[][]board , int r , int c , char num){

        // check row
        for(int j = 0; j < 9; j++){
            if(j != c && board[r][j] == num) return false;
        }
        // check col
        for(int i = 0; i < 9; i++){
            if(i != r && board[i][c] == num) return false;
        }
        // check 3*3 matrix
        int sRow = r/3*3;
        int sCol = c/3*3;
        for (int i = sRow; i < sRow + 3; i++) {
            for (int j = sCol; j < sCol + 3; j++) {
                if (board[i][j] == num) return false;     
            }
        }
        return true;
    }

    public void solve(char[][]board , int r , int c , char[][]grid){
        
        if(r == 9){
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    grid[i][j] = board[i][j];
                }
            }
            return;
        }

        else if(board[r][c] != '.'){ // for non empty cell
            if(c != 8) solve(board,r,c+1,grid);
            else solve(board,r+1,0,grid);
        }
        else{ // for empty cell ('.')
            for(char ch = '1'; ch <= '9'; ch++){
                if(isValid(board,r,c,ch)){
                    board[r][c] = ch;
                    if(c != 8) solve(board,r,c+1,grid);
                    else solve(board,r+1,0,grid);
                    board[r][c] = '.';
                }
            }
        }

    }

    public void solveSudoku(char[][] board) {
        char[][]grid = new char[9][9];
        solve(board,0,0,grid);

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                board[i][j] = grid[i][j];
            }
        }

    }

}
