import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> participantList = new HashMap<>();
        
        for (String p : participant) {
            participantList.put(p, participantList.getOrDefault(p, 0) + 1);
        }
        
        for (String c : completion) {
            participantList.put(c, participantList.get(c) - 1);
        }
        
        for (String key : participantList.keySet()) {
            if (participantList.get(key) != 0) {
                answer += key;
            }
        }   
        
        return answer;
    }
}