import java.util.*;

class Solution {
    
    static String answer = "";
    
    public String solution(String p) {
        
        if (isCorrect(p)) {
            return p;
        }
        
        return func(p);
    }
    
    static String func(String p) {
        
        if (p.isEmpty()) {
            return "";
        }
        
        String u = "", v = "";
        int count = 0;
        
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            
            if (c == '(') {
                count += 1;
            } else {
                count -= 1;
            }
            
            u += c;
            
            if (count == 0) {
                v = p.substring(i + 1);
                break;
            }
            
        }
        
        if (isCorrect(u)) {
            return u + func(v);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("(").append(func(v)).append(")");
            sb.append(reverse(u.substring(1, u.length() - 1)));
            return sb.toString();
        }
        
    }
    
    static boolean isCorrect(String s) {
        int count = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count += 1;
            } else {
                count -= 1;
            }
            
            if (count < 0) {
                return false;
            }
        }
        
        return true;
    }
    
    static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                sb.append(")");
            } else {
                sb.append("(");
            }
        }
        return sb.toString();
    }
    
}