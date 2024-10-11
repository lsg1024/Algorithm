class Solution {
    
    static int answer;
    static int[] U, D, L, R;
    static int[][] graph;
    static boolean[][][] visited;
    
    public int solution(String dirs) {
        answer = 0;
        
        U = new int[] {-1, 0};
        D = new int[] {1, 0};
        L = new int[] {0, -1};
        R = new int[] {0, 1};
        
        graph = new int[11][11];
        visited = new boolean[11][11][4];
        
        dfs(5, 5, 0, dirs);
        
        return answer;
    }
    
    static void dfs(int x, int y, int depth, String dirs) {
        
        if (depth == dirs.length()) {
            return;
        }
        
        char dir = dirs.charAt(depth);
        int nx = x;
        int ny = y;
        
        if (dir == 'U') {
            nx += U[0];
            ny += U[1];
        } else if (dir == 'D') {
            nx += D[0];
            ny += D[1];
        } else if (dir == 'R') {
            nx += R[0];
            ny += R[1];
        } else if (dir == 'L') {
            nx += L[0];
            ny += L[1];
        }

        if (0 <= nx && nx < 11 && 0 <= ny && ny < 11) {
            
            int direction = getDirection(dir);
            int redirection = getReverseDirection(dir);
            
            if (!visited[x][y][direction] && !visited[nx][ny][redirection]) {
                visited[x][y][direction] = true;
                visited[nx][ny][redirection] = true;
                answer++;
            } 
            
            dfs(nx, ny, depth + 1, dirs);
            
        } else {
            dfs(x, y, depth + 1, dirs);
        }
      
    }
    
     static int getDirection(char dir) {
         if (dir == 'U') {
             return 0;
         } else if (dir == 'D') {
             return 1;
         } else if (dir == 'R') {
             return 2;
         } else {
             return 3;
         }
    }
    
    static int getReverseDirection(char dir) {
         if (dir == 'U') {
             return 1;
         } else if (dir == 'D') {
             return 0;
         } else if (dir == 'R') {
             return 3;
         } else {
             return 2;
         }
    }
    
}