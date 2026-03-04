import java.util.*;

class Solution {
    public long solution(String expression) {
        long answer = 0;
        
        List<String> tokens = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(expression, "*-+", true);
        
        while (st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }
        
        String[][] operters = new String[][] {
            {"*", "+", "-"},
            {"*", "-", "+"},
            {"+", "*", "-"},
            {"+", "-", "*"},
            {"-", "+", "*"},
            {"-", "*", "+"}
        };
        
        for (String[] operter : operters) {
            
            List<String> temp = new ArrayList<>(tokens);
            
            for (String op : operter) {
                List<String> newList = new ArrayList<>();
                
                for (int i = 0; i < temp.size(); i++) {
                    
                    String value = temp.get(i);
                    if (value.equals(op)) {
                        
                        long left = Long.parseLong(newList.remove(newList.size() - 1));
                        long right = Long.parseLong(temp.get(++i));
                        
                        long result = 0L;
                        if (op.equals("*")) {
                            result = left * right;
                            
                        } else if (op.equals("+")) {
                            result = left + right;
                        } else {
                            result = left - right; 
                        }
                        newList.add(String.valueOf(result));
                    } else {
                        newList.add(value);
                    }
                    
                }
                
                temp = newList;
            }
            
            answer = Math.max(answer,
                    Math.abs(Long.parseLong(temp.get(0))));
            
        }
        
        return answer;
    }
}