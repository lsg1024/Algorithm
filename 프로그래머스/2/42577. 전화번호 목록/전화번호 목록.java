import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashMap<String, Boolean> map = new HashMap<>();
        
        for (String number : phone_book) {
            map.put(number, true);
        }
        
        for (String number : phone_book) {
            for (int i = 1; i < number.length(); i++) {
                String num = number.substring(0, i);
                if (map.containsKey(num)) {
                    answer = false;
                    return answer;
                }
            }
        }
        
        return answer;
    }
}