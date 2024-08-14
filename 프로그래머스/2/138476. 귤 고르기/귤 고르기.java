import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        
        for (int i = 0; i < tangerine.length; i++) {
            
            int index = tangerine[i];
            hashmap.put(index, hashmap.getOrDefault(index,  0) + 1); 
            
        }
        
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(hashmap.entrySet());
        entryList.sort((o1, o2) -> hashmap.get(o2.getKey()) - hashmap.get(o1.getKey()));
        
        int totalCount = 0;
        for (Map.Entry<Integer, Integer> entry : entryList) {
            
            if (totalCount + entry.getValue() >= k) {
                answer++;
                break;
            }
            totalCount += entry.getValue();
            answer++;
        }
        

        
        return answer;
    }
}