import java.util.*;

class Solution {
    
    static HashMap<String, Integer> word_package = new HashMap<>();
    
    public int[] solution(String msg) {
        int[] answer;
        
        for (int i = 0; i < 26; i++) {
            word_package.put(Character.toString(i + 'A'), i + 1);
        }
        
        ArrayList<Integer> number_package = new ArrayList<>();
        
        int index = 27;
        
        while(!msg.isEmpty()) {
            String word = "";
            int i = 0;
            
            while (i < msg.length() && word_package.containsKey(msg.substring(0, i + 1))) {
                word = msg.substring(0, i + 1);
                i++;
            }
            
            number_package.add(word_package.get(word));
            
            if (i < msg.length()) {
                String next_word = msg.substring(0, i + 1);
                word_package.put(next_word, index++);
            }
            
            msg = msg.substring(word.length());
        }
        
        answer = new int[number_package.size()];
        for (int i = 0; i < number_package.size(); i++) {
            answer[i] = number_package.get(i);
        }
        
        
        return answer;
    }

}