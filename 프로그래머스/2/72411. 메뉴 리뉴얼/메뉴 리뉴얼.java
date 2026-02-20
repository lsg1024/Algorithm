import java.util.*;

class Solution {
    
    static HashMap<String, Integer> menus;
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for (int size : course) {
            menus = new HashMap<>();
            
            for (String order : orders) {
                if (order.length() < size) {
                    continue;
                }
                
                char[] menu = order.toCharArray();
                Arrays.sort(menu);
                
                combination(menu, 0, size, new StringBuilder());
            }
            
            if (menus.isEmpty()) continue;
            
            int maxCount = Collections.max(menus.values());
            
            if (maxCount < 2) continue;
            
            for (String key : menus.keySet()) {
                if (menus.get(key) == maxCount) {
                    answer.add(key);
                }
            }
        }
        
        Collections.sort(answer);
        
        return answer.toArray(new String[0]);
    }
    
    static void combination(char[] menu, int start, int r, StringBuilder current) {
        
        if (current.length() == r) {
            String key = current.toString();
            menus.put(key, menus.getOrDefault(key, 0) + 1);
            return;
        }
        
        for (int i = start; i < menu.length; i++) {
            current.append(menu[i]);
            combination(menu, i + 1, r, current);
            current.deleteCharAt(current.length() - 1);
        }
        
    }
}