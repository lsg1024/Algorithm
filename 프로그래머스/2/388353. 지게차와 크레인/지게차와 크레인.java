import java.util.*;

class Solution {
    
    int answer, H, W;
    
    public int solution(String[] storage, String[] requests) {
        answer = storage.length * storage[0].length();
        
        H = storage.length + 2;
        W = storage[0].length() + 2;
        
        char[][] containers = new char[H][W];
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                containers[i][j] = '-';
            }
        }
        
        for (int i = 1; i < H - 1; i++) {
            String input = storage[i - 1];
            for (int j = 1; j < W - 1; j++) {
                containers[i][j] = input.charAt(j - 1);
            }
        }
        
        for (String request : requests) {
            
            char target = request.charAt(0);
            
            if (request.length() == 2) {
                
                for (int i = 0; i < H; i++) {
                    for (int j = 0; j < W; j++) {
                        if (containers[i][j] == target) {
                            containers[i][j] = '-';
                            answer--;
                        }
                    }
                }
                
            } else {
                bfs(containers, target);
            }
            
        }
        
        return answer;
    }
    
    public void bfs(char[][] containers, char target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        
        boolean[][] visited = new boolean[H][W];
        visited[0][0] = true;
        
        int[] dx = new int[] {1, -1, 0, 0};
        int[] dy = new int[] {0, 0, 1, -1};
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (0 <= nx && nx < H && 0 <= ny && ny < W && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    
                    if (containers[nx][ny] == target) {
                        answer--;
                        containers[nx][ny] = '-';
                    } else if (containers[nx][ny] == '-') {
                        queue.offer(new int[] {nx, ny});
                    }
                }
            }
        }
    }
}