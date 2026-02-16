import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int n = nums.length/2;
        
        HashSet<Integer> hs = new HashSet<>();
        
        for (int num : nums) {
            hs.add(num);
        }

        
        if (hs.size() > n) {
            return n;
        } else {
            return hs.size();
        }
        
    }
}