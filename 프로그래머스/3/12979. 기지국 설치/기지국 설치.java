import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int lastPosition = 0;
        int range = 2 * w + 1;
        
        for (int station : stations) {
            int start = station - w;
        
            int uncover = start - lastPosition - 1;
            answer += (uncover + range - 1) / range;
            lastPosition = station + w;
        }
        
        if (lastPosition < n) {
            int uncover = n - lastPosition;
            answer += (uncover + range - 1) / range;
        }

        return answer;
    }
}