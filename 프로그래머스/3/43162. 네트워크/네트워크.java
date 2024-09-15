import java.util.*;

class Solution {
    
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                bfs(n, computers, i);
            }
        }
        
        return answer;
    }
    
    static void bfs(int n, int[][] computers, int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);
        visited[index] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int i = 0; i < n; i++) {
                
                if (computers[current][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }   
            }
            
        }
        return;
    }
}