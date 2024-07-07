import java.util.ArrayList;

public class transformMatrix {
    
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int r2 = mat.length;
        int c2 = mat[0].length;
    
        if (r * c != r2 * c2) {
            return mat; // Cannot reshape if total elements don't match
        }
    
        ArrayList<Integer> ls = new ArrayList<>();
    
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                ls.add(mat[i][j]);
            }
        }
    
        int[][] res = new int[r][c];
        int k = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int ele = ls.get(k);
                res[i][j] = ele;
                k++;
            }
        }
        return res;
    }
    

    public static void main(String[] args) {
        int[][] arr = { {1, 2}, {3, 4} };
        int[][]ans = matrixReshape(arr, 1, 4);

        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[0].length; j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }

}
