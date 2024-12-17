class Solution {
    
    static int[][] dp;
    
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;

        dp = new int[board.length + 1][board[0].length + 1];
        
        for (int[] sk : skill) {
            degreeBoard(sk); 
        }
    
        for (int colum = 0; colum < dp[0].length; colum++) {
            for (int row = 1; row < dp.length; row++) {
                 dp[row][colum] += dp[row - 1][colum];
            }
        }
        
        for (int row = 0; row < dp.length; row++) {
            for (int colum = 1; colum < dp[row].length; colum++) {
                dp[row][colum] += dp[row][colum - 1];
            }
        }
      
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = board[i][j] + dp[i][j];
                if (board[i][j] > 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    static void degreeBoard(int[] skill) {
        int type = skill[0];
        int r1 = skill[1];
        int c1 = skill[2];
        int r2 = skill[3];
        int c2 = skill[4];
        int degree = skill[5];
        
        if (type == 1) {
            degree *= -1;
        }
        
        dp[r1][c1] += degree;
        dp[r2 + 1][c2 + 1] += degree;
        dp[r1][c2 + 1] += degree * -1;
        dp[r2 + 1][c1] += degree * -1;

    }
    
}