import java.util.*;

class Solution {
    
    static int N, M;
    static int[] dx, dy;
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        N = maps.length;
        M = maps[0].length;
        
        dx = new int[] {1, -1, 0, 0};
        dy = new int[] {0, 0, 1, -1};
        
        return bfs(maps, 0, 0);
    }
    
    static int bfs(int[][] maps, int x, int y) {
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y, 1});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int nx = current[0];
            int ny = current[1];
            int distance = current[2];
            
            if (nx == N - 1 && ny == M - 1) {
                return distance;
            }
            
            for (int i = 0; i < 4; i++) {
                int nnx = nx + dx[i];
                int nny = ny + dy[i];
                
                if (0 <= nnx && nnx < N && 0 <= nny && nny < M && maps[nnx][nny] == 1) {
                    maps[nnx][nny] = 0;
                    queue.offer(new int[] {nnx, nny, distance + 1});
                }  
              
            }
        }
        
        return -1;
               
    }
}