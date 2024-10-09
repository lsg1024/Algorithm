import java.util.*;

class Solution {

    public int solution(int n, int k) {
        int answer = 0;
        
        String input = Integer.toString(n, k);
        
        input = input.replaceAll("0+", " ");
        
        String[] numbers = input.split(" ");
        
        for (String number : numbers) {
            
            long num = Long.parseLong(number);
            
            if (isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
     private boolean isPrime(long num) {
        if (num < 2) return false; 
        for (long j = 2; j <= Math.sqrt(num); j++) {
            if (num % j == 0) {
                return false; 
            }
        }
        return true; 
    }
}