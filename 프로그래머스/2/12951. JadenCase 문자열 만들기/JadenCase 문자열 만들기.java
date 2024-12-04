import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] input = s.toLowerCase().split("");
        boolean isFirst = true;
        for (int i = 0; i < s.length(); i++) {
            answer += isFirst ? input[i].toUpperCase() : input[i];
            isFirst = input[i].equals(" ") ? true : false;
        }
        
        return answer;
    }
}