import java.util.*;

class Solution {
    
    public int solution(int[] numbers, int target) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        
        dp.put(numbers[0], 1);
        dp.put(-numbers[0], dp.getOrDefault(-numbers[0], 0) + 1);
        
        for (int i = 1; i < numbers.length; i++) {
            HashMap<Integer, Integer> nextDp = new HashMap<>();
            
            for (int sum : dp.keySet()) {
                int count = dp.get(sum);
                
                nextDp.put(sum + numbers[i], nextDp.getOrDefault(sum + numbers[i], 0) + count);
                nextDp.put(sum - numbers[i], nextDp.getOrDefault(sum - numbers[i], 0) + count);
                
            }
            dp = nextDp;
        }
        
        return dp.getOrDefault(target, 0);
    }
}