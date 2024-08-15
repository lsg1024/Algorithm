import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();
        
        for (int t : topping) {
            left.put(t, left.getOrDefault(t, 0) + 1);
        }
        
        for (int t : topping) {
            right.put(t, right.getOrDefault(t, 0) + 1);
            
            if (left.get(t) - 1 == 0) {
                left.remove(t);
            }
            else {
                left.put(t, left.get(t) - 1);
            }
            
            if (left.size() == right.size()) {
                answer++;
            }
        }    
    
        return answer;
    }
}