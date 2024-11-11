import java.util.*;

class Solution {
    
    static HashMap<String, String> nicknames = new HashMap<>();
    
    public String[] solution(String[] record) {
        String[] answer;
        Queue<String[]> IOLogs = new LinkedList<>();

        for (int i = 0; i < record.length; i++) {
            String[] split_record = record[i].split(" ");
            
            String type = split_record[0];
            String userId = split_record[1];
            String userName;
            if (!type.equals("Leave")) {
                userName = split_record[2];   
                nicknames.put(userId, userName);
            }
            if (!type.equals("Change")) {
                IOLogs.offer(new String[] {type, userId});    
            }
        }
        
        answer = new String[IOLogs.size()];
        
        int idx = 0;
        while (!IOLogs.isEmpty()) {
            String[] current = IOLogs.poll();
            String tpye = current[0];
            String userId = current[1];
            
            String userName = nicknames.get(userId);
            if (tpye.equals("Enter")) {
                answer[idx] = userName + "님이 들어왔습니다.";
            } else {
                answer[idx] = userName + "님이 나갔습니다.";
            }
            idx++;
        }
        
        return answer;
    }
    
}

