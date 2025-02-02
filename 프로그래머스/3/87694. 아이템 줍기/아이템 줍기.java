import java.util.*;

class Solution {
    
    static int[] dx = new int[] {1, -1, 0, 0};
    static int[] dy = new int[] {0, 0, 1, -1};
    static int[][] graph = new int[102][102];
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        for (int[] space : rectangle) {
            int x1 = space[0] * 2;
            int y1 = space[1] * 2;
            int x2 = space[2] * 2;
            int y2 = space[3] * 2;
            
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    if (x == x1 || x == x2 || y == y1 || y == y2) {
                        if (graph[x][y] != 2) {
                           graph[x][y] = 1; 
                        }
                    } else {
                        graph[x][y] = 2;
                    }
                }
            }
            
        }
        
        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }
    
    static int bfs(int characterX, int characterY, int itemX, int itemY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {characterX, characterY});
        
        int[][] distance = new int[102][102];
        distance[characterX][characterY] = 1;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            if (x == itemX && y == itemY) {
                return (distance[x][y] - 1) / 2;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (0 <= nx && nx < 102 && 0 <= ny && ny < 102 && distance[nx][ny] == 0 && graph[nx][ny] == 1) {
                    distance[nx][ny] = distance[x][y] + 1;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
        
        return 0;
    }
}