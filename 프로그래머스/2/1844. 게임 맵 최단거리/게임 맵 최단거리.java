import java.util.*;

class Solution {
    
    static int N, M, count;
    static int[] dx, dy;
    static int[][] visited;
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        N = maps.length;
        M = maps[0].length;
        
        dx = new int[] {1, -1, 0, 0};
        dy = new int[] {0, 0, 1, -1};
        
        visited = new int[N][M];
        
        count = 0;
        bfs(maps, 0, 0);
        
        return visited[N - 1][M - 1] == 0 ? -1 : visited[N - 1][M - 1];
    }
    
    static void bfs(int[][] maps, int x, int y) {
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int nx = current[0];
            int ny = current[1];
            
            for (int i = 0; i < 4; i++) {
                int nnx = nx + dx[i];
                int nny = ny + dy[i];
                
                
                
                if (0 <= nnx && nnx < N && 0 <= nny && nny < M && visited[nnx][nny] == 0 && maps[nnx][nny] == 1) {
                    visited[nnx][nny] = visited[nx][ny] + 1;
                    queue.offer(new int[] {nnx, nny});
                }  
              
            }
        }
               
    }
}