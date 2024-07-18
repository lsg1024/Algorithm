import java.util.*;

class Solution {

    char[][] map;
    boolean[][] visited;
    int row, col;

    public int[] solution(String[] maps) {
        col = maps.length;
        row = maps[0].length();
        
        map = new char[col][row];
        visited = new boolean[col][row];
        
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                char c = maps[i].charAt(j);
                if (c == 'X') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = c;
                }
            }
        }
        
        ArrayList<Integer> islandSizes = new ArrayList<>();
        
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    int size = dfs(i, j);
                    islandSizes.add(size);
                }
            }
        }
        
        if (islandSizes.isEmpty()) {
            return new int[] {-1};
        }
        
        Collections.sort(islandSizes);
        
        int[] answer = new int[islandSizes.size()];
        
        for (int i = 0; i < islandSizes.size(); i++) {
            answer[i] = islandSizes.get(i);
        }
        
        return answer;
    }

    public int dfs(int y, int x) {
        if (x < 0 || y < 0 || x >= row || y >= col) return 0;
        if (map[y][x] == 0 || visited[y][x]) return 0;

        visited[y][x] = true;
        int size = map[y][x] - '0';
        
        size += dfs(y + 1, x);
        size += dfs(y - 1, x);
        size += dfs(y, x + 1);
        size += dfs(y, x - 1);

        return size;
    }
}
