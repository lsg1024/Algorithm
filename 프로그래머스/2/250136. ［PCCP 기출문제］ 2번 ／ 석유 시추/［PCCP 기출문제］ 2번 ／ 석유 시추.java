import java.util.*;

class Solution {
    
    static int N, M;
    static int[] dx = new int[] {1, -1, 0, 0};
    static int[] dy = new int[] {0, 0, 1, -1};
    static int[][] oilIds;
    static HashMap<Integer, Integer> oils = new HashMap<>();
    
    public int solution(int[][] land) {
        int answer = 0;
        
        N = land.length;
        M = land[0].length;
        
        oilIds = new int[N][M];

        int oilId = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (land[i][j] == 1 && oilIds[i][j] == 0) {
                    int size = dfs(land, i, j, oilId);
                    oils.put(oilId, size);
                    oilId++;
                }
            }
            
        }
        
        int maxOil = 0;
        for (int i = 0; i < M; i++) {
            HashSet<Integer> visited = new HashSet<>();
            
            int oil = 0;
            for (int j = 0; j < N; j++) {
                if (oilIds[j][i] != 0 && !visited.contains(oilIds[j][i])) {
                    oil += oils.get(oilIds[j][i]);
                    visited.add(oilIds[j][i]);
                }
            }
       
            maxOil = Math.max(maxOil, oil);
        }
        
        
        return maxOil;
    }
    
    static int dfs(int[][] land, int x, int y, int id) {
        
        if (land[x][y] == 0 || oilIds[x][y] != 0) {
            return 0;
        }
        
        oilIds[x][y] = id;
        int count = 1;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                count += dfs(land, nx, ny, id);
            }
        }   
        
        return count;
    } 
}