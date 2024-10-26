import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        
        for (int i = 0; i < s.length(); i++) {
            Stack<String> stack = new Stack<>();
            boolean isValid = true;
            
            for (int j = 0; j < s.length(); j++) {
                String type = Character.toString(s.charAt(j));
                
                if (stack.isEmpty()) {
                    if (type.equals(")") || type.equals("]") || type.equals("}")) {
                        isValid = false;
                        break;   
                    }
                }
                
                if (type.equals("(") || type.equals("[") || type.equals("{")) {
                    stack.push(type);
                } else {
                    String top = stack.peek();
                    if ((type.equals(")") && top.equals("(")) ||
                        (type.equals("]") && top.equals("[")) ||
                        (type.equals("}") && top.equals("{"))) {
                        stack.pop();
                    } else {
                        isValid = false; 
                        break; 
                    }
                }
            }
            s = s.substring(1, s.length()) + s.substring(0, 1);
            
            if (isValid && stack.isEmpty()) {
                answer++;
            } 
        }
        
        return answer;
    }
}