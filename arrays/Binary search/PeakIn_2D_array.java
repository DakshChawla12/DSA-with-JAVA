
public class PeakIn_2D_array {
    public int findMaxIdx(int[][] mat, int n, int m, int col) {
        int maxi = Integer.MIN_VALUE, index = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (mat[i][col] > maxi) {
                maxi = mat[i][col];
                index = i;
            }
        }
        return index;
    }

    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int s = 0, e = m - 1;
        int[] res = new int[2];
        int mid = s + (e - s) / 2;
        while (s <= e) {
            int maxRowIdx = findMaxIdx(mat, n, m, mid);
            int left = mid - 1 >= 0 ? mat[maxRowIdx][mid - 1] : -1;
            int right = mid + 1 < m ? mat[maxRowIdx][mid + 1] : -1;

            if (mat[maxRowIdx][mid] > left && mat[maxRowIdx][mid] > right) {
                res = new int[]{maxRowIdx, mid};
                return res;
            } else if (mat[maxRowIdx][mid] < left) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
            mid = s + (e - s) / 2;
        }
        res = new int[]{-1, -1};
        return res;
    }
}
