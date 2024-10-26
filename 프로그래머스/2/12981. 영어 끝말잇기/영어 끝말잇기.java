import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer;

        Stack<String> stack = new Stack<>();
        
        for (int i = 0; i < words.length; i++) {
            if (stack.isEmpty()) {
                stack.push(words[i]);
            } else {
                String bf_word = stack.peek();
                String s_1 = bf_word.substring(bf_word.length() - 1);
                
                String s_2 = words[i].substring(0, 1);
                
                if (!s_1.equals(s_2)) {
                    return new int[] {i % n + 1, i / n + 1,};
                } else if (stack.contains(words[i])) {
                    return new int[] {i % n + 1, i / n + 1};
                } else {
                    stack.push(words[i]);
                }
                
            }
        }

        return new int[] {0, 0};
    }
}