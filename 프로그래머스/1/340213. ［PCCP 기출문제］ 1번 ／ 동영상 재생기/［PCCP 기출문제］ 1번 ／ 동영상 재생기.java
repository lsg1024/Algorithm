class Solution {
    
    static StringBuilder sb;
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        // 오프닝 시작
        String[] ops_times = op_start.split(":");
        int op_s = Integer.parseInt(ops_times[0]) * 60 + Integer.parseInt(ops_times[1]);
        
        // 오프닝 종료
        String[] ope_times = op_end.split(":");
        int op_e = Integer.parseInt(ope_times[0]) * 60 + Integer.parseInt(ope_times[1]);
        
        // 첫 시작이 오프닝일 경우
        String[] first_pos = pos.split(":");
        int f_pos = Integer.parseInt(first_pos[0]) * 60 + Integer.parseInt(first_pos[1]);
        
        if (op_s <= f_pos && f_pos <= op_e) {
            pos = op_end;
        }
    
        for (String command : commands) {
            if (command.equals("prev")) {
                pos = prev(pos, op_s, op_e, op_end);
            }
            else {
                pos = next(pos, video_len, op_s, op_e, op_end);
            }
        }
        
        return pos;
    }
    
    static String prev(String Time, int ops, int ope, String op_end) {
        
        String[] times = Time.split(":");
    
        int time = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
        
        System.out.println(time);
        
        if (time - 10 < 0) {
            
            if(!isOpenTime(ops, ope, 0)) {
                return op_end;
            }
            
            return "00:00";
        }
        
        else {
            time -= 10;
            
            if(!isOpenTime(ops, ope, time)) {
                return op_end;
            }
            
            String minute = String.format("%02d", time / 60);
            String secound = String.format("%02d", time % 60);
            
            return minute + ":" + secound;
        }
         
    }
    
    static String next(String Time, String video_len, int ops, int ope, String op_end) {
        
        String[] times = Time.split(":");
        int time = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
        
        String[] video_times = video_len.split(":");
        int total_len = Integer.parseInt(video_times[0]) * 60 + Integer.parseInt(video_times[1]);    
        
        if (time + 10 > total_len) {
            return video_len;
        }
        else {
            time += 10;
            
            if(!isOpenTime(ops, ope, time)) {
                return op_end;
            }
            
            String minute = String.format("%02d", time / 60);
            String secound = String.format("%02d", time % 60);
            
            return minute + ":" + secound;
        }
         
    }
    
    static boolean isOpenTime(int ops, int ope, int time) {
        
        if (ops <= time && time <= ope) {
            return false;
        }
        
        return true;
    }
    
    
}