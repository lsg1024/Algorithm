import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[] {priorities[i], i});
        }
        
        while (!queue.isEmpty()) {
            
            int[] current = queue.poll();
            boolean highPriority = false;
            
            for (int[] process : queue) {
                if (process[0] > current[0]) {
                    highPriority = true;
                    break;
                }
            }
            
            if (highPriority) {
                queue.offer(current);
            }
            else {
                answer++;
                
                if (current[1] == location) {
                    return answer;
                }
            }
            
        }
        
        return answer;
    }
}