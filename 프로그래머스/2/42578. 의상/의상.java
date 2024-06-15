import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, HashSet> map = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
            String item = clothes[i][0];
            String type = clothes[i][1];
            
            map.putIfAbsent(type, new HashSet<String>());
            
            map.get(type).add(item);
        }
        
        for (String key : map.keySet()) {
            int value = map.get(key).size();
            answer *= (value + 1);
        }
        
        return answer - 1;
    }
}