import java.util.*;

class Solution {
    
    char[][] map;
    int[] start, exit, labber, dx, dy;
    int row, col;
    
    public int solution(String[] maps) {
        int answer = 0;
        
        col = maps.length;
        row = maps[0].length();
        
        map = new char[col][row];
        
        start = new int[2];
        exit = new int[2];
        labber = new int[2];
        
        dx = new int[] {-1, 1, 0, 0};
        dy = new int[] {0, 0, -1, 1};
        
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                char c = maps[i].charAt(j);
                map[i][j] = c;
                if (c == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
                if (c == 'E') {
                    exit[0] = i;
                    exit[1] = j;
                }
                if (c == 'L') {
                    labber[0] = i;
                    labber[1] = j;
                }
            }
        }
        
        int toLabber = bfs(start[0], start[1], labber);
        if (toLabber == -1) return -1;
        
        int toExit = bfs(labber[0], labber[1], exit);
        if (toExit == -1) return -1;
        
        answer = toLabber + toExit;
        
        return answer;
    }
    
   public int bfs (int sy, int sx, int[] target) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[col][row];
        q.add(new int[] {sy, sx, 0});
        visited[sy][sx] = true;
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cur_y = current[0];
            int cur_x = current[1];
            int cur_count = current[2];
            
            if (cur_y == target[0] && cur_x == target[1]) {
                return cur_count;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = cur_x + dx[i];
                int ny = cur_y + dy[i];
                
                if (nx >= 0 && nx < row && ny >= 0 && ny < col && !visited[ny][nx] && map[ny][nx] != 'X') {
                    visited[ny][nx] = true;
                    q.add(new int[] {ny, nx, cur_count + 1});
                }
            }
        }
        
        return -1;
    }
}