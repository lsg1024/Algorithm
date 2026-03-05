import java.util.*;

class Solution {
    
    static int dic = 27;
    static List<Integer> out_put = new ArrayList<>();
    static HashMap<String, Integer> words = new HashMap<>();
    
    public int[] solution(String msg) {
        int[] answer;
        
        for (int i = 0; i < 26; i++) {
            words.put(String.valueOf((char) ('A' + i)), i + 1);
        }
        
        String[] s_msg = msg.split("");
        ArrayList<String> msgList = new ArrayList<>();
        
        for (int i = 0; i < s_msg.length; i++) {
            msgList.add(s_msg[i]);
        }
        
        String w = "";
        
        for (char c : msg.toCharArray()) {
            String wc = w + c;
            
            if (words.containsKey(wc)) {
                w = wc;
            } else {
                out_put.add(words.get(w));
                words.put(wc, dic++);
                w = String.valueOf(c);
            }
            
        }
        
        if (!w.isEmpty()) {
            out_put.add(words.get(w));
        }

        answer = new int[out_put.size()];
        for (int i = 0; i < out_put.size(); i++) {
            answer[i] = out_put.get(i);
        }
        
        return answer;
    }
    
}