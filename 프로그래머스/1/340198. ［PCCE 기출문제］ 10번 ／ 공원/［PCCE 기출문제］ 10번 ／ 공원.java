import java.util.*;

class Solution {
    
    static int X, Y;
    static int[] dx = new int[] {1, -1, 0, 0};
    static int[] dy = new int[] {0, 0, 1, -1};
    static boolean[][] visited;
    
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        
        int[] sort_mats = Arrays.stream(mats)
            .boxed()
            .sorted(Collections.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();
        
        X = park.length;
        Y = park[0].length;
        
        visited = new boolean[X][Y];
        
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (park[i][j].equals("-1")) {
                    visited[i][j] = true;
                }
            }
        }
        
        for (int i = 0; i < sort_mats.length; i++) {
            
            int mat = sort_mats[i];
            
            for (int j = 0; j <= X - mat; j++) {
                for (int k = 0; k <= Y - mat; k++) {
                    if (visited[j][k]) {
                        if (dfs(j, k, mat)) {
                            return mat;
                        }
                    }
                }
            }
            
        }

        return answer;
    }
    
    static boolean dfs(int x, int y, int mat) {
        
        for (int i = 0; i < mat; i++) {
            for (int j = 0; j < mat; j++) {
                if (!visited[x + i][y + j]) {
                    return false;
                }
            }
        }
        return true;
    }
}