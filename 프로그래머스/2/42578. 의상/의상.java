import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> clothesType = new HashMap<>();
        
        for (String[] cloth : clothes) {
            String type = cloth[1];
            clothesType.put(type, clothesType.getOrDefault(type, 0) + 1);
        }
    
        for (int count : clothesType.values()) {
            answer *= (count + 1);
        }
        
        return answer - 1;
    }
}