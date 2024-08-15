import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        int m_value = d / k;
        long value = 0;
        
        for (int i = 0; i <= m_value; i++) {
            long x = k * i;
            long x_pow = (long) Math.pow(x, 2);
            long d_pow = (long) Math.pow(d, 2);
    
            long result = (long) Math.sqrt(d_pow - x_pow);
            result = result / k;
            answer += result + 1;
        }
        
        return answer;
    }
}