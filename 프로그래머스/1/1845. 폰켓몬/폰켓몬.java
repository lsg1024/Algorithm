import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        HashSet<Integer> pocketmonType = new HashSet<>();
        
        int n = nums.length / 2;
        
        for (int i = 0; i < nums.length; i++) {
            pocketmonType.add(nums[i]);
        }
              
        answer = n > pocketmonType.size() ? pocketmonType.size() : n;
        
        return answer;
    }
}