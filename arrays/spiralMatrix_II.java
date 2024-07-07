
public class spiralMatrix_II {
    public static int[][] generateMatrix(int n) {
        
        int[][]res = new int[n][n];

        int sRow = 0;
        int eRow = n-1;

        int sCol = 0;
        int ecol = n-1;

        int total = n*n , count = 0 , ele = 1;

        while(count < total && ele <= total){
            for(int i = sCol; count<total && i <= ecol; i++){
                res[sRow][i] = ele;
                count++;ele++;
            }
            sRow++;
            for(int i = sRow; count < total && i <= eRow; i++){
                res[i][ecol] = ele;
                count++;ele++;
            }
            ecol--;
            for(int i = ecol; count < total && i >= sCol; i--){
                res[eRow][i] = ele;
                count++;ele++;
            }
            eRow--;
            for(int i = eRow; count < total && i >= sRow; i--){
                res[i][sCol] = ele;
                count++;ele++;
            }
            sCol++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][]arr = generateMatrix(3);
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
