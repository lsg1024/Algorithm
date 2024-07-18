import java.util.*;

class Solution {
    
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        // bfs 어떻게 보면 최소 비용 값을 구하는 문제
        answer = bfs(x, y, n);
        
        return answer;
    }
    
    public int bfs(int x, int y, int n) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[y - x + 1];
        q.add(new int[] {x, 0});
        visited[0] = true;
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int current_x = current[0];
            if (current_x == y) return current[1];
            
            if (current_x * 3 <= y && !(visited[current_x * 3 - x])) {
                q.add(new int[] {current_x * 3, current[1] + 1});
                visited[current_x * 3 - x] = true;
            }
            
            if (current_x * 2<= y && !(visited[current_x * 2 - x])) {
                q.add(new int[] {current_x * 2, current[1] + 1});
                visited[current_x * 2 - x] = true;
            }
            
            if (current_x + n <= y && !(visited[current_x + n - x])) {
                q.add(new int[] {current_x + n, current[1] + 1});
                visited[current_x + n - x] = true;
            }
            
        }
        
        return -1;
    }
}