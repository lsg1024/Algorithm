import java.util.*;

class Solution {
    
    static
    
    public String solution(String p) {
        String answer = "";
        
        String result = func(p);
        
        return result;
    }
    
    static String func(String p) {
        
        if (p.isEmpty()) {
            return "";
        }
        
        int left = 0;
        int right = 0;
        String u = "";
        String v = "";
        
        for (char c : p.toCharArray()) {
            if (c == '(') {
                left++;
            } else {
                right++;
            }
            
            if (left == right) {
                u = p.substring(0, left + right);
                v = p.substring(left + right);
                break;
            }
        }
        
        // u 검증 true 올바른, false 틀린
        if (isValid(u)) {
            return u + func(v);
        } else {
            String uu = u.substring(1, u.length() - 1);
            String vv = makeValid(uu);

            return "(" + func(v) + ")" + vv;
        }
        
    }
    
    static boolean isValid(String w) {
        
        int count = 0;
        
        for (char c : w.toCharArray()) {
            if (c == '(') {
                count++;
            } else {
                count--;
            }
            
            if (count < 0) {
                return false;
            }
        }
        
        return count == 0;
    }
    
    // 재귀 처리
    static String makeValid(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        
        return sb.toString();
    }
    
}