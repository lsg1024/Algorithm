import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] != o2[1]) { 
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        
        int time = 0;
        int sum = 0;
        int index = 0;
        while (index < jobs.length || !pq.isEmpty()) {
            while (index < jobs.length && jobs[index][0] <= time) {
                pq.offer(jobs[index]);
                index++;
            }
            
            if (!pq.isEmpty()) {
                int[] job = pq.poll();
                time += job[1];
                sum += time - job[0];
            } else {
                time = jobs[index][0];
            }
            
        }
        
        return sum / jobs.length;
    }
}
