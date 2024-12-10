import java.util.*;

class Solution {
    
    static int START_TIME = 540;
    
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        int total = n * m;
        int bf_take = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for (String times : timetable) {
            String[] time = times.split(":");
            int hour = Integer.parseInt(time[0]) * 60;
            int minute = Integer.parseInt(time[1]);
            
            if (hour + minute < START_TIME) {
                bf_take++;
            }
            arr.add(hour + minute);
        }
        
       Collections.sort(arr);
        
        if (bf_take != 0) {
            if (bf_take >= total) {
                START_TIME = arr.get(arr.size() - 1) - 1;
                answer = String.format("%02d:%02d", START_TIME / 60, START_TIME % 60);
            } else if (bf_take < total) {
                answer = String.format("%02d:%02d", START_TIME / 60, START_TIME % 60);
            } else {
                n -= 1;
            }
        }
        
        for (int i = 0; i < n; i++) {
        
            int can_move = m;
            int last = 0;
            
            while (can_move > 0 && arr.size() > 0) {
                
                int time = arr.get(0);   
                
                if (time <= START_TIME) {
                    last = time;
                    arr.remove(0);
                    can_move--;
                } else {
                    break;
                }
                
            }
              
            if (i == n - 1) {
                if (can_move > 0) {
                    answer = String.format("%02d:%02d", START_TIME / 60, START_TIME % 60);
                } else {
                    last -= 1;
                    answer = String.format("%02d:%02d", last / 60, last % 60);
                }
            }
            
            START_TIME += t;
        }
        
        return answer;
    }
}