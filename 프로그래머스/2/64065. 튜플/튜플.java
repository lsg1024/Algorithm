import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String s) {
        int[] answer = {};
        
        s = s.substring(2, s.length() - 2);
        String[] groups = s.split("\\},\\{");
        
        Arrays.sort(groups, (o1, o2) -> o1.length() - o2.length());
        
        ArrayList<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        for (String group : groups) {
            String[] nums = group.split(",");
            
            for (String num : nums) {
                int number = Integer.parseInt(num);
                
                if (!set.contains(number)) {
                    result.add(number);
                    set.add(number);
                }
                
            }
        }
        
        return result;
    }
}