import java.util.*;

class Solution {
    
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int playSec = timeTosec(play_time);
        int advSec = timeTosec(adv_time);
        
        int[] times = new int[playSec + 1];
        
        for (String log : logs) {
            String[] split_log = log.split("-");
            int start = timeTosec(split_log[0]);
            int end = timeTosec(split_log[1]);
            
            times[start] += 1;
            times[end] -= 1;
        }
        
        for (int i = 1; i <= playSec; i++) {
            times[i] += times[i - 1];
        }
        
        long maxView = 0;
        long curView = 0;
        
        for (int i = 0; i < advSec; i++) {
            curView += times[i];
        }
        
        long maxStart = 0;
        
        for (int i = advSec; i <= playSec; i++) {
            curView += times[i] - times[i - advSec];
            if (curView > maxView) {
                maxView = curView;
                maxStart = i - advSec + 1;
            }
        }
        
        // System.out.println(secTotime((int) maxStart));
        
        return secTotime((int) maxStart);
    }
    
    //초로 변환
    static int timeTosec(String time) {
        String[] parts = time.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int s = Integer.parseInt(parts[2]);
        
        return h * 3600 + m * 60 + s;
    }
    
    //날짜로 변환
    static String secTotime(int seconds) {
        int h = seconds / 3600;
        int m = (seconds % 3600) / 60;
        int s = (seconds % 3600) % 60;
        
        if (h == 0 && m == 0 && s == 1) {
            s = 0;
        }
        
        return String.format("%02d:%02d:%02d", h, m, s);
    }
    
}