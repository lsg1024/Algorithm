import java.util.*;

class Solution
{
    public int solution(String s)
    {

        Stack<String> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            
            String ss = Character.toString(s.charAt(i));
            
            if (stack.isEmpty()) {
                stack.push(ss);
            } else {
                if (stack.peek().equals(ss)) {
                    stack.pop();
                } else {
                    stack.push(ss);
                }
            }
        }
        
        return stack.isEmpty() ? 1 : 0;
        
    }
    
}