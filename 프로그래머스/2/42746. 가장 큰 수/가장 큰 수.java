import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] str = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(str, (o1, o2) -> {
            String number1 = o1 + o2;
            String number2 = o2 + o1;
            
            return number2.compareTo(number1);
        });
        
        if (str[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }
        
        return sb.toString();
    }
}