import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] times = new int[24];
        
        for (int i = 0; i < players.length; i++) {
            
            int need_server = players[i] / m;   
            int time = times[i];
            
            if (time >= need_server) continue;
            
            int shortage  = need_server - times[i];
                    
            if (shortage > 0) {
                answer += shortage;

                for (int j = i; j < Math.min(i + k, 24); j++) {
                    times[j] += shortage; 
                }
            }
            
        }
    
        return answer;
    }
}