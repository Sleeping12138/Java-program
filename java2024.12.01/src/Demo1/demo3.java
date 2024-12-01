package Demo1;

public class demo3 {
    public int n, m;
    int[] x = {0, 0, -1, 1};
    int[] y = {1, -1, 0, 0};

    public int solve(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxLen = Math.max(dfs(matrix, i, j), maxLen);
            }
        }
        return maxLen;
    }

    public int dfs(int[][] matrix, int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m) return 0;

        int max = 0;
        for (int k = 0; k < 4; k++) {
            int newX = i + x[k], newY = j + y[k];
            if (matrix[newX][newY] > matrix[i][j]) {
                max = Math.max(max, dfs(matrix, newX, newY) + 1);
            }
        }
        return max;
    }
}
