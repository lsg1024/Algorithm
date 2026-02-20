import java.util.*;

class Solution {
    
    static HashMap<String, Integer> types = new HashMap<>();
    static {
        types.put("R", 0);
        types.put("T", 0);
        types.put("C", 0);
        types.put("F", 0);
        types.put("J", 0);
        types.put("M", 0);
        types.put("A", 0);
        types.put("N", 0);
    };
    
    static HashMap<Integer, Integer> scores = new HashMap<>();
    static {
        scores.put(1, 3);
        scores.put(2, 2);
        scores.put(3, 1);
        scores.put(4, 0);
        scores.put(5, 1);
        scores.put(6, 2);
        scores.put(7, 3);
    }
    
    static String[][] numbers = {
        {"R", "T"},
        {"C", "F"},
        {"J", "M"},
        {"A", "N"}
    };
    
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        for (int i = 0; i < survey.length; i++) {
            String o1 = null;
            String o2 = null;
            for (int j = 0; j < survey[i].length(); j++) {
                if (j == 0) {
                    o1 = String.valueOf(survey[i].charAt(j));
                } else {
                    o2 = String.valueOf(survey[i].charAt(j));
                }
            }
            
            int choice = choices[i];
            
            if (choice < 4) {
                types.put(o1, types.getOrDefault(o1, 0) + scores.get(choice));
            } else if (choice > 4) {
                types.put(o2, types.getOrDefault(o2, 0) + scores.get(choice));
            } else {
                continue;
            }
            
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            String key1 = numbers[i][0];
            String key2 = numbers[i][1];
            
            int o1 = types.get(key1);
            int o2 = types.get(key2);
            
            if (o1 > o2) {
                sb.append(key1);
            } else if (o1 < o2) {
                sb.append(key2);
            } else {
                if (key1.compareTo(key2) != -1) {
                    sb.append(key1);
                } else {
                    sb.append(key2);
                }
            }
        }
        
        return sb.toString();
    }
}