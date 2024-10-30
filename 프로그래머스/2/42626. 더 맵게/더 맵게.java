import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int hot : scoville) {
            pq.offer(hot);
        }
        
        while (pq.peek() < K) {
            
            if (pq.size() < 2 && pq.poll() < K) {
                return -1;
            }
            
            int last_scoville = pq.poll();
            int second_scoville = pq.poll();
            
            int mix_scoville = last_scoville + (second_scoville * 2);
            pq.offer(mix_scoville);
            answer++;
            
        }
        
        
        
        return answer;
    }
}