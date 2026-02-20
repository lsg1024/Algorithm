import java.util.*;

class Solution {
    
    static HashMap<String, String> users = new HashMap<>();
    static List<String[]> status = new ArrayList<>();
    
    public String[] solution(String[] record) {
        String[] answer;
        
        for (int i = 0; i < record.length; i++) {
            String[] input = record[i].split(" ");

            String type = input[0];
            String uuid = input[1];
            
            if (type.equals("Enter")) {
                String nickname = input[2];
                users.put(uuid, nickname);
                
                status.add(new String[] {uuid, "님이 들어왔습니다."});
            } else if (type.equals("Leave")) {
                
                status.add(new String[] {uuid, "님이 나갔습니다."});
            } else {
                String nickname = input[2];
                users.put(uuid, nickname);
            }
            
            
        } 
        
        answer = new String[status.size()];
        for (int i = 0; i < status.size(); i++) {
            String[] stat = status.get(i);
            String nickname = users.get(stat[0]);
            
            answer[i] = nickname + stat[1];
        }
        
        return answer;
    }
}