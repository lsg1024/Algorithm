import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
         Arrays.sort(routes, (o1, o2) -> {
            if (o1[1] != o2[1]) { 
                return o1[1] - o2[1];
            } else { 
                return o1[0] - o2[0];
            }
        });
        
        int minPosition = Integer.MIN_VALUE;
        for (int[] route : routes) {
            if (minPosition < route[0]) {
                answer++;
                minPosition = route[1];
            }
        }
        
        
        return answer;
    }
}