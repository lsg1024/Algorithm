class Solution {
    
    static int count = 0;
    static int[][] graph;
    
    public int solution(int n) {

        graph = new int[n][n];
        
        dfs(n, 0);
        
        return count;
    }
    
    static void dfs(int n, int depth) {
        
        if (depth == n) {
            count++;
            return;
        }
            
        for (int i = 0; i < n; i++) {
            if (isVisited(depth, i, n)) {
                graph[depth][i] = 1;
                dfs(n, depth + 1);
                graph[depth][i] = 0;
            }
        }
    }
        
    // 상, 좌상, 우상
    static boolean isVisited(int depth, int y, int n) {
        
        //상
        for (int i = 0; i < depth; i++) {
            if (graph[i][y] == 1) {
                return false;
            }
        }
        
        //좌상
        for (int i = 1; depth - i >= 0 && y + i < n; i++) {
            if (graph[depth - i][y + i] == 1) {
                return false;
            }
        }
        
        for (int i = 1; depth - i >= 0 && y - i >= 0; i++) {
            if (graph[depth - i][y - i] == 1) {
                return false;
            }
        }
        
        return true;
    }
    
}