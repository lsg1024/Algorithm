import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        HashSet<String> gemList = new HashSet<>(Arrays.asList(gems));
        int gemTypeCount = gemList.size();
        
        HashMap<String, Integer> showCase = new HashMap<>();
        
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        
        while (right < gems.length) {
            
            showCase.put(gems[right], showCase.getOrDefault(gems[right], 0) + 1);
            right++;
            
            while (showCase.size() == gemTypeCount) {
                
                if (right - left < minLength) {
                    minLength  = right - left;
                    answer[0] = left + 1;
                    answer[1] = right;
                }
                
                showCase.put(gems[left], showCase.get(gems[left]) - 1);
                if (showCase.get(gems[left]) == 0) {
                    showCase.remove(gems[left]);
                }
                
                left++;
            }
        }
        
        return answer;
    }
}