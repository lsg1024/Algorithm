import java.util.*;

class Solution {
    public int solution(int [][]board) {
        int answer = 0;
        
        int col = board.length;
        int row = board[0].length;
        
        int[][] dp = new int[col][row];
        
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (board[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = board[i][j];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    }
                }
                answer = Math.max(answer, dp[i][j]);
            }
        }
        
        return answer * answer;
    }
}