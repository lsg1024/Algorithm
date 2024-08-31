import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;

        Queue<String> qe = new LinkedList<>();
        
        for (int i = 0; i < s.length(); i++) {
            
            String st = Integer.toString(s.charAt(i));
            
            if (qe.isEmpty()) {
                
                if (st.equals("41")) {
                    return false;
                }
                else {
                    qe.offer(st);
                }
              
            }
            
            else {
                if (qe.peek().equals("40") && st.equals("41")) {
                    qe.poll();
                }
                else {
                    qe.offer(st);
                }
            }   
        }

        if (qe.isEmpty()) {
            return true;
        }
        
        return answer;
    }
}