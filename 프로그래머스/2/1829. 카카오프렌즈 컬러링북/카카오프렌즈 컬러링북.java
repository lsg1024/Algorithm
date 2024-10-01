class Solution {
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        boolean[][] visited = new boolean[picture.length][picture[0].length];
        
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    numberOfArea++;
                    int currentAreaSize = dfs(i, j, picture, visited);
                    if (maxSizeOfOneArea < currentAreaSize) {
                        maxSizeOfOneArea = currentAreaSize;
                    }
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
    
    static int dfs(int x, int y, int[][] picture, boolean[][] visited) {
        
        int target = picture[x][y];
        int count = 1;
        
        visited[x][y] = true;        
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (0 <= nx && nx < picture.length && 0 <= ny && ny < picture[0].length && !visited[nx][ny] && picture[nx][ny] == target) {
                count += dfs(nx, ny, picture, visited);
            }
        }
        
        return count;
    }
    
}