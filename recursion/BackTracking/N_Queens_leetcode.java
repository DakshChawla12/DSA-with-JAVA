import java.util.ArrayList;
import java.util.List;

/*
Time Complexity (TC): O(n!)
Space Complexity (SC): O(n^2)
 */

public class N_Queens_leetcode {
    
    public static boolean isSafe(char[][] board, int row, int col){

        int n = board.length;
        // check row
        for(int j = 0; j < n; j++){
            if(board[row][j] == 'Q') return false;
        }
        // check column
        for(int i = 0; i < n; i++){
            if(board[i][col] == 'Q') return false;
        }

        // check north-east
        int i = row;
        int j = col;
        while(i >= 0 && j < n){
            if(board[i][j] == 'Q') return false;
            i--;j++;
        }
        // check south-east
        i = row;
        j = col;
        while(i < n && j < n){
            if(board[i][j] == 'Q') return false;
            i++;j++;
        }
        // check south-west
        i = row;
        j = col;
        while(i < n && j >= 0){
            if(board[i][j] == 'Q') return false;
            i++;j--;
        }
        // check north-west
        i = row;
        j = col;
        while(i >= 0 && j >= 0){
            if(board[i][j] == 'Q') return false;
            i--;j--;
        }
        return true;
    }

    private static void nQueens(char[][] board, int row, List<List<String>>ans) {
        int n = board.length;
        if(row == n){
            // convert 2d char array to list of string
            List<String>ls = new ArrayList<>();
            for(int i = 0; i < n; i++){
                String str = "";
                for(int j = 0; j < n; j++){
                    str += board[i][j];
                }
                ls.add(str);
            }
            ans.add(ls);
            return;
        }

        for(int j = 0; j < n; j++){ // traversing through the row
            if(isSafe(board,row,j)) {
                board[row][j] = 'Q';
                nQueens(board, row+1, ans);
                board[row][j] = '.';
            }
        }

    }

    public static List<List<String>> solveNQueens(int n) {
        char[][]board = new char[n][n];
        List<List<String>>ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        nQueens(board , 0, ans);
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>>ans = solveNQueens(n);
        System.out.println(ans);
    }

}
