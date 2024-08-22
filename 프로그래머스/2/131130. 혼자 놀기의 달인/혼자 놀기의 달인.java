import java.util.*;

class Solution {   
    
    public int solution(int[] cards) {
        int answer = 0;
        
        boolean[] visited = new boolean[cards.length];
        PriorityQueue<Integer> boxs = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < cards.length; i++) {
            if (!visited[i]) {
                int boxSize = dfs(i, cards, visited);
                boxs.add(boxSize);
            }
        }
        
        if (boxs.size() >= 2) {
            int num_1 = boxs.poll();
            int num_2 = boxs.poll();
            
            return num_1 * num_2;
        }
        
        return answer;
    }
    
    public int dfs(int start, int[] cards, boolean[] visited) {
        
        int s_start = start;
        int size = 0;
        
        while (!visited[s_start]) {
            visited[s_start] = true;
            s_start = cards[s_start] - 1;
            size++;
        }
        
        return size;

    }
}