import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";

        StringBuilder words = new StringBuilder();

        for (int i = 0; i < t * m; i++) {
            words.append(Integer.toString(i, n));
        }
    
        for (int i = p - 1; i < t * m; i += m) {
            answer += words.substring(i, i + 1).toUpperCase();
        }

        
        return answer;
    }
}