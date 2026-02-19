import java.util.*;

class Solution {
    
    static String[][] maps;
    static int[] dx = new int[] {1, -1, 0, 0};
    static int[] dy = new int[] {0, 0, 1, -1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            String[] place = places[i];
            
            maps = new String[5][5];
            
            for (int j = 0; j < 5; j++) {
                String input = place[j];
                for (int k = 0; k < 5; k++) {
                    String p = String.valueOf(input.charAt(k));
                    maps[j][k] = p;
                }
            }
            
            boolean isValid = true;
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (maps[j][k].equals("P")) {
                        if (!bfs(j, k)) {  
                            isValid = false;
                            break;
                        }
                    }
                }
            }
            
            answer[i] = isValid == true ? 1 : 0;

        }
        
        return answer;
    }
    
    static boolean bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y, 0});
        boolean[][] visited = new boolean[5][5];
        visited[x][y] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int nx = current[0];
            int ny = current[1];
            int dist = current[2];
            
            if (dist > 0 && dist <= 2 && maps[nx][ny].equals("P")) {
                return false;
            }
            
            if (dist >= 2) {
                continue;
            }
            
            for (int i = 0; i < 4; i++) {
                int nnx = nx + dx[i];
                int nny = ny + dy[i];
                
                if (0 <= nnx && nnx < 5 && 0 <= nny && nny < 5 && !visited[nnx][nny] && !maps[nnx][nny].equals("X")) {
                    queue.add(new int[] {nnx, nny, dist + 1});
                    visited[nnx][nny] = true;
                }
            }
            
        }
        
        return true;
    }
}