import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.add(begin);
        visited.add(begin);
        
        int count = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                
                for (String word : words) {
                    if (!visited.contains(word) && isDifferent(current, word)) {
                        if (word.equals(target)) {
                            return count;
                        }
                        
                        visited.add(word);
                        queue.add(word);
                    }
                }
            }
        }
        
        return 0;
    }
    
    static boolean isDifferent(String word1, String word2) {
        
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
                
                if (diff > 1) {
                    return false;
                }
            }
        }
        
        return true;
        
    }
}