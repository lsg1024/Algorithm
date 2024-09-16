import java.util.*;

class Solution {
    
    static int[][] graph, visited;
    static int[] dx, dy;
    
    public int solution(int[][] rectangles, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        graph = new int[102][102];
        visited = new int[102][102];
        
        dx = new int[] {1, -1, 0, 0};
        dy = new int[] {0, 0, 1, -1};
        
        // graph 생성 후 rectangle 범위 값을 채우기
        for (int[] rectangle : rectangles) {
            int x1 = rectangle[0] * 2;
            int y1 = rectangle[1] * 2;
            int x2 = rectangle[2] * 2;
            int y2 = rectangle[3] * 2;
            
            for (int y = y1; y <= y2; y++) {
                for (int x = x1; x <= x2; x++) {
                    // 테투리와 내부 분리
                    if (x == x1 || x == x2 || y == y1 || y == y2) {
                        if (graph[y][x] != 2) {
                            graph[y][x] = 1;
                        }
                    }
                    else {
                        graph[y][x] = 2;
                    }
                }
            }
        }
        
        // 좌표 이동 기존 bfs 이용해
        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2) / 2;
    }
    
    static int bfs(int start_x, int start_y, int t_x, int t_y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start_x, start_y});
        visited[start_y][start_x] = 1;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            if (x == t_x && y == t_y) {
                return visited[y][x] - 1;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (0 <= nx && nx < 102 && 0 < ny && ny < 102 && visited[ny][nx] == 0 && graph[ny][nx] == 1) {
                    queue.offer(new int[] {nx, ny});
                    visited[ny][nx] = visited[y][x] + 1;    
                }
                
            }
            
        }
        return 0;
    }
    
}