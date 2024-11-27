import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        
        int low = 0;
        int high = 0;
        
        for (int stone : stones) {
            high = Math.max(stone, high);
        }
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            int distance = 0;
            boolean canCross = true;
            
            for (int i = 0; i < stones.length; i++) {
                if (stones[i] - mid <= 0) {
                    distance++;
                    if (distance >= k) {
                        canCross = false;
                        break;
                    }
                } else {
                    distance = 0;
                }
            }
            
            if (canCross) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }         
        
        return low;
    }
}