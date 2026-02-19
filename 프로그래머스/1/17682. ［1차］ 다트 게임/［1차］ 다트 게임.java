import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < dartResult.length(); i++) {
            String s = String.valueOf(dartResult.charAt(i));
            
            if (s.equals("S")) {
                stack.push((int) Math.pow(stack.pop(), 1));
                
            } else if (s.equals("D")) {
                stack.push((int) Math.pow(stack.pop(), 2));
                
            } else if (s.equals("T")) {
                stack.push((int) Math.pow(stack.pop(), 3));
                
            } else if (s.equals("*")) {
                int last = stack.pop();
                
                if (!stack.isEmpty()) {
                    int prev = stack.pop();
                    stack.push(prev * 2);
                }
                
                stack.push(last * 2);
                
            } else if (s.equals("#")) {
                stack.push(stack.pop() * -1);
            } else {
                String next = String.valueOf(dartResult.charAt(i + 1));
                
                if (next.equals("0")) {
                    s = "10";
                    i += 1;
                }
                
                stack.push(Integer.parseInt(s));
            }
        }
        
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }
        
        return answer;
    }
}