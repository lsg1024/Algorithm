import java.util.*;

class Solution {
    
    static TreeMap<String, Integer> totalTime = new TreeMap<>();
    static HashMap<String, String> map = new HashMap<>();
    
    public int[] solution(int[] fees, String[] records) {
        int[] answer;
        
        // 또 출차 후 들어올 수 있음
        for (String record : records) {
            String[] s_record = record.split(" ");
            String time = s_record[0];
            String car = s_record[1];
            String type = s_record[2];
            
            if (type.equals("IN")) {
                map.put(car, time);
                
            } else {
                String[] start = map.get(car).split(":");
                int s_hour = Integer.parseInt(start[0]) * 60;
                int s_minute = Integer.parseInt(start[1]);
                int start_time = s_hour + s_minute;
                
                String[] end = time.split(":");
                int e_hour = Integer.parseInt(end[0]) * 60;
                int e_minute = Integer.parseInt(end[1]);
                int end_time = e_hour + e_minute;
                
                int t_time = end_time - start_time;
                
                totalTime.put(car, totalTime.getOrDefault(car, 0) + t_time);
                
                map.remove(car);
            }
        }
        
        for (String key : map.keySet()) {
            String[] start = map.get(key).split(":");
            int s_hour = Integer.parseInt(start[0]) * 60;
            int s_minute = Integer.parseInt(start[1]);
            int start_time = s_hour + s_minute;
            
            int t_time = 1439 - start_time;
            totalTime.put(key, totalTime.getOrDefault(key, 0) + t_time);
        }
        
        
        answer = new int[totalTime.size()];
        int index = 0;
        for (String key : totalTime.keySet()) {
            int time = totalTime.get(key);
            
            if (time <= fees[0]) {
                answer[index++] = fees[1];
                continue;
            }
            
            int extraTime = time - fees[0];
            
            int extraCeliTime = (int) Math.ceil((double) extraTime / fees[2]);
            
            answer[index++] = extraCeliTime * fees[3] + fees[1];
        }
        
        return answer;
    }

}