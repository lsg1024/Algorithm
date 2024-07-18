import java.util.*;

class Solution {
    
    int[][] sorted_Time;
    public int solution(String[][] book_time) {
        int answer = 0;
        
        // 정렬은 시작 시간 타임으로 정렬
        // 시간이 겹치면 방 추가
        // 끝 시간과 겹치지 않는 시작 시간이 없으면 방 늘리기
        // 정비 시간 10분 추가
        
        // start, end
        sorted_Time = new int[book_time.length][2];
        
        for (int i = 0; i < book_time.length; i++) {
            String[] start = book_time[i][0].split(":");
            String[] end = book_time[i][1].split(":");
            
            sorted_Time[i][0] = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            sorted_Time[i][1] = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]) + 10;
        }
        
        //오름차순
        Arrays.sort(sorted_Time, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int[] time : sorted_Time) {
        
            if (!pq.isEmpty() && pq.peek() <= time[0]) {
                pq.poll();
            }
            pq.offer(time[1]);
        }
    
        answer = pq.size();
        
        return answer;
    }

}