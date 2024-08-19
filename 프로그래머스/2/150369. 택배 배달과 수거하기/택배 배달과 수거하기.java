import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int d = 0, p = 0;  // 현재 트럭에 실린 배달과 수거 상자 수
    
        for (int i = n - 1; i >= 0; i--) {
            int roundTrips = 0; 
            
            // 최대한 수거할 수 있는 횟수 구하기 
            while (d < deliveries[i] || p < pickups[i]) {
                roundTrips++;
                d += cap;
                p += cap;
            }
            
            answer += (i + 1) * roundTrips * 2;
            
            d -= deliveries[i];
            p -= pickups[i];
        }
        
        return answer;
    }
}
