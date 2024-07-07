import java.util.*;

public class validSudoku {
     // approach 1
    public boolean isValidSudoku(char[][] board) {
        HashSet<String>seen = new HashSet<>();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){

                if(board[i][j] != '.'){
                    if(!seen.add("row"+i+board[i][j]) || !seen.add("col"+j+board[i][j])){
                    return false;
                    }
                    int boxIndex = (i/3)*3 + j/3;
                    if(!seen.add("box"+boxIndex+board[i][j])){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // approach 2

    public static boolean isValid(char[][]board , int r , int c , char num){

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
                if (board[i][j] == num)
                    return false;
            }
        }
        return true;
    }

    public static boolean helper(char[][]board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                char num = board[i][j];
                board[i][j] = '.';
                if(isValid(board,i,j,num) == false) return false;
                board[i][j] = num;
            }
        }
        return true;
    }
}
