import java.util.*;

class Solution {
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static String[][] graph;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for (int i = 0; i < places.length; i++) {
            
            graph = new String[5][5];
            String[] place = places[i];
            
            for (int j = 0; j < places[i].length; j++) {
                String p = place[j];
                for (int k = 0; k < p.length(); k++) {
                    String pp = String.valueOf(p.charAt(k));
                    graph[j][k] = pp;
                }
            }
            
            boolean isValid = true;
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (graph[j][k].equals("P")) {
                        if (!bfs(j, k)) {  
                            isValid = false;
                            break;
                        }
                    }
                }
            }
            
            answer[i] = isValid ? 1 : 0;
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
            x = current[0];
            y = current[1];
            int depth = current[2];
            
            if (0 < depth && depth < 3 && graph[x][y].equals("P")) {
                return false;
            }
            
            if (depth > 3) continue;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (0 <= nx && nx < 5 && 0 <= ny && ny < 5 && !visited[nx][ny] && !graph[nx][ny].equals("X")) {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx,ny, depth + 1});
                }
            }
        }
        
        return true;
    }
    
}