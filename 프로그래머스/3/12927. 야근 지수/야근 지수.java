import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int work : works) {
            pq.offer(work);
        }
        
        while (n > 0) {
            int number = pq.poll();
            
            if (number - 1 >= 0) {
                pq.offer(--number);
                n--;
            } else {
                pq.offer(number);
                n = 0;
            }
        
        }
        
        while (!pq.isEmpty()) {
            answer += Math.pow(pq.poll(), 2);
        }
        
        return answer;
    }
}