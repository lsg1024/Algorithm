class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        int size = sequence.length;
        
        long[] dp1 = new long[size + 1];
        long[] dp2 = new long[size + 1];
        
        dp1[0] = sequence[0];
        dp2[0] = -sequence[0];
        
        long maxSum1 = dp1[0];
        long maxSum2 = dp2[0];
        
        int pulse = 1;
        for (int i = 1; i < size; i++) {
            dp1[i] = Math.max(dp1[i - 1] + sequence[i] * -pulse, sequence[i] * -pulse);
            maxSum1 = Math.max(dp1[i], maxSum1);
                
            dp2[i] = Math.max(dp2[i - 1] + sequence[i] * pulse, sequence[i] * pulse);
            maxSum2 = Math.max(dp2[i], maxSum2);
            
            pulse *= -1;
        }
        
        return Math.max(maxSum1, maxSum2);
    }
}