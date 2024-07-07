
public class wordSearch {
    
    public boolean helper(char[][]board , String word , int i , int j , int n , int m , int k){
        if(k >= word.length()) return true;
        if(i < 0 || j < 0 || i >= n || j >= m || board[i][j] == 'X') return false;
        if(word.length() == 1 && word.charAt(k) == board[i][j]) return true;
        if(word.charAt(k) != board[i][j]) return false;

        board[i][j] = 'X';
        boolean temp = false;
        int[] x = {0, 0, -1, 1};
        int[] y = {-1 , 1, 0, 0};
        for(int idx = 0; idx < 4; idx++){
            temp = temp || helper(board,word,i+x[idx],j+y[idx],n,m,k+1);
        }

        board[i][j] = word.charAt(k);
        return temp;
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] ==  word.charAt(0)){
                    if(helper(board,word,i,j,n,m,0)) return true;
                }
            }
        }
        return false;
    }

}
