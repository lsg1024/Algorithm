class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        
        int[][] top = new int[m + 1][n + 1];
        int[][] down = new int[m + 1][n + 1];
        
        top[1][1] = 1;
        down[1][1] = 1;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (cityMap[i - 1][j - 1] == 2) {
                    top[i][j] = top[i][j - 1];
                    down[i][j] = down[i - 1][j];
                }
                if (cityMap[i - 1][j - 1] == 0) {
                    top[i][j] += (top[i][j - 1] + down[i - 1][j]) % MOD;
                    down[i][j] += (top[i][j - 1] + down[i - 1][j]) % MOD;
                }
            }
        }
        
        return (top[m][n - 1] + down[m - 1][n]) % MOD;
    }
}