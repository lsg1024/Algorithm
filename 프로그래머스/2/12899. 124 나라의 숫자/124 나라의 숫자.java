import java.util.*;

class Solution {
    
    static int[] numbers = new int[] {1, 2, 4};
    
    public String solution(int n) {
        String answer = "";
        
        long total = 0;
        int k = 0;
        
        //몇번째 자리인지 구하기
        while (total < n) {
            k++;
            total += Math.pow(3, k);
        }
        
         //k자리수 내 위치 결정
        long previousTotal = total - (long)Math.pow(3, k);
        long position = n - previousTotal - 1;
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            long p = (long)Math.pow(3, k - i - 1);
            int idx = (int)(position / p);
            sb.append(numbers[idx]);
            position %= p;
        }
        
        return sb.toString();
    }
}