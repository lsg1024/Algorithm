import java.util.*;
import java.util.regex.*;

class Solution {
    public int[] solution(String s) {
        int[] answer;
        
        String number = "";
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            
            if (Character.isDigit(s.charAt(i))) {
                number = number + Integer.toString(s.charAt(i) - '0');
            }
            else {
                if (number.equals("")) {
                    continue;
                }
                else {
                    arr.add(number);
                    number = "";
                }
            }
        }
        
        HashMap<String, Integer> hashmap = new HashMap<>();
        
        for (int i = 0; i < arr.size(); i++) {
            hashmap.put(arr.get(i), hashmap.getOrDefault(arr.get(i), 0) + 1);
        }
        
        ArrayList<Map.Entry<String, Integer>> entryList = new ArrayList<>(hashmap.entrySet());
        
        entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());
        
        answer = new int[entryList.size()];
        
        int index = 0;
        for (Map.Entry<String, Integer> entry : entryList) {
            answer[index] = Integer.parseInt(entry.getKey());
            index++;
        }
        
     
        return answer;
    }
}