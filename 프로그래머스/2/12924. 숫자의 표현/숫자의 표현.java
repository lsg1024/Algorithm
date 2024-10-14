class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] dp = new int[n + 1];
        
        dp[0] = 0;
        
        for (int i = 1; i < n + 1; i++) {
            dp[i] = i + dp[i - 1];
        }
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = i; j >= 0; j--) {
                int number = dp[i] - dp[j];
                if (number > n) {
                    break;
                } else if (number == n) {
                    answer += 1;
                }
            }
        }
        
        return answer;
    }
}