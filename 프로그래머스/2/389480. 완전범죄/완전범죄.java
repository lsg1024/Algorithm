import java.util.*;

class Solution {
    
    int answer = Integer.MAX_VALUE;
    int N, M;
    boolean[][][] visited;
    
    public int solution(int[][] info, int n, int m) {
        
        N = n;
        M = m;
        
        visited = new boolean[info.length][n + 1][m + 1];
        dfs(info, 0, 0, 0);
        
        if (answer == Integer.MAX_VALUE) return -1;
        
        return answer;
    }
    
    public void dfs(int[][] info, int idx, int a, int b) {
        if (a >= N || b >= M) {
            return;
        }
        
        if (idx == info.length) {
            answer = Math.min(answer, a);
            return;
        }
        
        if (visited[idx][a][b]) return;
        visited[idx][a][b] = true;
        
        dfs(info, idx + 1, a + info[idx][0], b);
        dfs(info, idx + 1, a, info[idx][1] + b);
    }
}