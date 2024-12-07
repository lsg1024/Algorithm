import java.util.*;

class Solution {
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] board) {
        
        int n = board.length;
        
        int[][][] cost = new int[n][n][4];
        for (int[][] row : cost) {
            for (int[] col : row) {
                Arrays.fill(col, Integer.MAX_VALUE);
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < 4; i++) {
            q.offer(new int[] {0, 0, i, 0});
            cost[0][0][i] = 0;
        }
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            int dir = current[2];
            int dir_cost = current[3];
            
            if (x == board.length - 1 && y == board.length - 1) {
                 continue;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (0 <= nx && nx < board.length && 0 <= ny && ny < board.length && board[nx][ny] == 0) {
                    
                    int newCost = dir_cost + 100;
                    
                    if (dir != i) {
                        newCost += 500;
                    }
                    
                    if (newCost < cost[nx][ny][i]) {
                        cost[nx][ny][i] = newCost;
                        q.offer(new int[] {nx, ny, i, newCost});
                    }
                    
                }
            }
        }
        
        return Arrays.stream(cost[board.length - 1][board.length - 1]).min().orElse(Integer.MAX_VALUE);
    }

}