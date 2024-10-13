import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        int n = number.length();
        int total_len = n - k;
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            char num = number.charAt(i);
            
            while (!stack.isEmpty() && stack.peek() < num && k > 0) {
                stack.pop();
                k--;
            }
            
            stack.push(num);
        }
        
        while (stack.size() > total_len) {
            stack.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}