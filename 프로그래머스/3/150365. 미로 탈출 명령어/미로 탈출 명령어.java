import java.util.*;

class Solution {
    
    int[] dx = {1, 0, 0, -1}; 
    int[] dy = {0, -1, 1, 0};
    String[] type = {"d", "l", "r", "u"};
    String answer = "impossible";
    boolean found = false;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        dfs(n, m, x - 1, y - 1, r - 1, c - 1, k, "");
        return answer;
    }
    
    public void dfs(int n, int m, int sx, int sy, int ex, int ey, int remain, String path) {  
        
        if (found) return;
        
        int dist = Math.abs(sx - ex) + Math.abs(sy - ey);
        if (dist > remain || (remain - dist) % 2 != 0) return;
        
        if (remain == 0) {
            if (sx == ex && sy == ey) {
                answer = path;
                found = true;
                return;
            }
            return;
        }

        for (int i = 0; i < 4; i++) { 
            int nx = sx + dx[i];
            int ny = sy + dy[i];

            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                dfs(n, m, nx, ny, ex, ey, remain - 1, path + type[i]);
            }
        }
        
    }
}
