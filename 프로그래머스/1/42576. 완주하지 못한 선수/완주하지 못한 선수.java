import java.util.*;
import java.lang.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> hashmap = new HashMap<>();
        
        // 마라톤 명단
        for (int i = 0; i < participant.length; i++) {
            hashmap.put(participant[i], hashmap.getOrDefault(participant[i], 0) + 1);
        }
        
        
        // 마라톤 완주 명단
        for (int i = 0; i < completion.length; i++) {
            hashmap.put(completion[i], hashmap.get(completion[i]) - 1);
        }
        
        for (String key : hashmap.keySet()) {
            if (hashmap.get(key) != 0) {
                answer = key;
            }
        }
        
        return answer;
    }
}