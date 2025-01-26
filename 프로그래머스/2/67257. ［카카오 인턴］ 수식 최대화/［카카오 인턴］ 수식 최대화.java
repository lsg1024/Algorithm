import java.util.*;

class Solution {
    
    String op[][] = { { "+", "-", "*" }, { "+", "*", "-" }, { "-", "*", "+" }, 
                         { "-", "+", "*" }, { "*", "-", "+" }, { "*", "+", "-" } };
    
    public long solution(String expression) {
        long answer = 0;
        
        StringTokenizer st = new StringTokenizer(expression, "*+-", true);
        
        int size = st.countTokens();
        List<Long> numbers = new ArrayList<>();
        List<String> signs = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String token = st.nextToken();
            
            if ("*+-".contains(token)) {
                signs.add(token);
            } else {
                numbers.add(Long.parseLong(token));
            }
        }
        
        for (String[] priority : op) {
            List<Long> new_numbers = new ArrayList<>(numbers);
            List<String> new_signs = new ArrayList<>(signs);
            
            for (String operator : priority) {
                for (int i = 0; i < new_signs.size();) {
                    if (new_signs.get(i).equals(operator)) {
                        long result = calculate(new_numbers.get(i), new_numbers.get(i + 1), operator);
                        new_numbers.set(i, result);
                        new_numbers.remove(i + 1);
                        new_signs.remove(i);
                    } else {
                        i++;
                    }
                }
            }
            
            answer = Math.max(answer, Math.abs(new_numbers.get(0)));
        }
        
        return answer;
    }
    
    static long calculate(long num1, long num2, String op) {
        if (op.equals("*")) {
            return num1 * num2;
        } else if (op.equals("+")) {
            return num1 + num2;
        } else {
            return num1 - num2;
        }
    }
}