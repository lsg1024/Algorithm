import java.util.*;

class Solution {
    
    int answer;
    int[] dist, weak_point;
    
    public int solution(int n, int[] weak, int[] dist) {
        answer = Integer.MAX_VALUE;
        this.dist = dist;
        
        int len = weak.length;
        weak_point = new int[len * 2];
        
        for (int i = 0; i < len; i++) {
            weak_point[i] = weak[i];
            weak_point[i + len] = weak[i] + n;
        }
        
        Arrays.sort(dist);
        
        for (int i = 0; i < len; i++) {
            dfs(i, 0, new boolean[dist.length], new int[dist.length]);
        }
        
        if (answer == Integer.MAX_VALUE) {
            return -1;
        }
        
        return answer;
    }
    
    public void dfs(int start, int count, boolean[] visited, int[] history) {
        
        if (count == dist.length) {
            answer = Math.min(answer,  check(start, start + weak_point.length / 2, history));
            return;
        }
        
        for (int i = 0; i < dist.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                history[count] = dist[i]; 
                dfs(start, count + 1, visited, history);
                visited[i] = false;
            }
        }
    }
    
    public int check(int start, int end, int[] history) {
        int index = 1;
        int distance = weak_point[start] + history[index - 1];
        
        for (int i = start; i < end; i++) {
            if (distance < weak_point[i]) {
                index++;
                if (index > history.length) return Integer.MAX_VALUE;
                
                distance = weak_point[i] + history[index - 1];
            }
        }
        return index;
    }
    
    
}