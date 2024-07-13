import java.util.*;

class Solution {
    
    int x, y;
    int[] start, end, dx, dy;
    String[][] graph;
    
    public int solution(String[] board) {
        int answer = 0;
        
        x = board[0].length();
        y = board.length;
        
        dx = new int[] {-1, 1, 0, 0};
        dy = new int[] {0, 0, -1, 1};
        
        graph = new String[y][x];
        
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                String value = board[i].substring(j, j + 1);
                graph[i][j] = value;
                
                if (value.equals("R")) {
                    start = new int[] {i, j};
                }
                
                if (value.equals("G")) {
                    end = new int[] {i, j};
                }
            }
        }
        
        answer = bfs(start[0], start[1]);
        
        return answer;
    }
    
    public int bfs(int sx, int sy) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[y][x];
        q.add(new int[] {sx, sy, 0});
        visited[sx][sy] = true;
         
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cur_x = current[0];
            int cur_y = current[1];
            int cur_depth = current[2];
            
            if (cur_x == end[0] && cur_y == end[1]) {
                return cur_depth;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = cur_x;
                int ny = cur_y;
                
                while (true) {
                    
                    int tx = nx + dx[i];
                    int ty = ny + dy[i];
                    
                    if (tx < 0 || tx >= y || ty < 0 || ty >= x || graph[tx][ty].equals("D")) {
                        break;
                    }
                    
                    nx = tx;
                    ny = ty;
                }
             
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[] {nx, ny, cur_depth + 1});
                }
            }
        }
        
        return -1;
    }
    
}