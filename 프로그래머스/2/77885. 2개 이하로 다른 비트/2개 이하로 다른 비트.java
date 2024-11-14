import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            long bit = 1;
            while ((num & bit) != 0) {
                bit <<= 1;
            }
            answer[i] = num + bit - (bit >> 1);
            
        }
        
        return answer;
    }
}