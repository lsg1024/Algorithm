import java.util.*;

class Solution {
    
    boolean[] visited;
    
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
    
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        int unit = n;
        int shield = k;
        
        for (int i = 0; i < enemy.length; i++) {
            unit -= enemy[i];
            queue.add(enemy[i]);
            
            if (unit < 0) {
                if (shield > 0) {
                    unit += queue.poll();
                    shield--;
                }
                else {
                    break;
                }
            }
            answer++;
        }
        
        return answer;
    }
}