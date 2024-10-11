import java.util.*;

class Solution {
    
    static char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static int count;
    static List<Condition> conditions;
    
    static class Condition {
        char first;
        char second;
        char operator;
        int distance;
        
        Condition(char first, char second, char operator, int distance) {
            this.first = first;
            this.second = second;
            this.operator = operator;
            this.distance = distance;
        }
    }
    
    public int solution(int n, String[] data) {
        count = 0;
        conditions = new ArrayList<>();
        
        for (String condition : data) {
            char first = condition.charAt(0);
            char second = condition.charAt(2);
            char operator = condition.charAt(3);
            int distance = condition.charAt(4) - '0';
            conditions.add(new Condition(first, second, operator, distance));
        }
        
        boolean[] used = new boolean[8];
        
        backtrack(new ArrayList<>(), used);  
        
        return count;
    }
    
    static void backtrack(List<Character> order, boolean[] used) {
        
        if (order.size() == 8) {
            if (isValid(order)) {
                count++;
            }
            return;
        }
        
        // 프렌즈 배치
        for (int i = 0; i < 8; i++) {
            if (!used[i]) {
                order.add(friends[i]);
                used[i] = true;
                
                // 배치 가능 여부
                if (isPartialValid(order)) {
                    backtrack(order, used);
                } 
                
                order.remove(order.size() - 1);
                used[i] = false;
            }
        }
        
    }
    
    static boolean isValid(List<Character> order) {
        
        for (Condition condition : conditions) {
            int p1 = order.indexOf(condition.first);
            int p2 = order.indexOf(condition.second);
            int p_distance = Math.abs(p1 - p2) - 1;
            
            if (condition.operator == '=') {
                if (p_distance != condition.distance) return false;
            } else if (condition.operator == '<') {
                if (p_distance >= condition.distance) return false;
            } else if (condition.operator == '>') {
                if (p_distance <= condition.distance) return false;
            }      
        }
        return true;
    }
    
    static boolean isPartialValid(List<Character> order) {
        
        HashMap<Character, Integer> pMap = new HashMap<>();
        for (int i = 0; i < order.size(); i++) {
            pMap.put(order.get(i), i);
        }
        
        for (Condition condition : conditions) {
            
            if (pMap.containsKey(condition.first) && pMap.containsKey(condition.second)) {
                int p1 = order.indexOf(condition.first);
                int p2 = order.indexOf(condition.second);
                int p_distance = Math.abs(p1 - p2) - 1;

                if (condition.operator == '=') {
                    if (p_distance != condition.distance) return false;
                } else if (condition.operator == '<') {
                    if (p_distance >= condition.distance) return false;
                } else if (condition.operator == '>') {
                    if (p_distance <= condition.distance) return false;
                }
            }
            
        }
        return true;
    }
    
}