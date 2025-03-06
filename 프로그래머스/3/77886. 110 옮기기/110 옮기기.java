import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for (int i = 0; i < s.length; i++) {
            
            String number = s[i];
            Stack<Character> stack = new Stack<>();
            int count = 0;
            
            for (int j = 0; j < number.length(); j++) {
                
                stack.push(number.charAt(j));
                
                if (stack.size() >= 3) {
                    char c3 = stack.pop();
                    char c2 = stack.pop();
                    char c1 = stack.pop();
                    
                    if (c1 == '1' && c2 == '1' && c3 == '0') {
                        count++;
                    } else {
                        stack.push(c1);
                        stack.push(c2);
                        stack.push(c3);
                    }
                }
            }
            
            
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            sb.reverse();

            int index = sb.lastIndexOf("0") + 1;
            if (index == 0) index = 0;

            StringBuilder result = new StringBuilder();
            result.append(sb.substring(0, index));
            while(count-- > 0) {
                result.append("110");
            }
            result.append(sb.substring(index));

            answer[i] = result.toString();
                
        }
        
        return answer;
    }
}