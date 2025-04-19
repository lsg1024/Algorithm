import java.util.*;

class Solution {
    
    static int[] dx = new int[] {1, -1, 0, 0};
    static int[] dy = new int[] {0, 0, 1, -1};
    static boolean[][] visited;
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = -1;
        
        int row = game_board.length;
        int col = game_board[0].length;
        List<List<int[]>> emptyboard = new ArrayList<>();
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (game_board[i][j] == 0 && !visited[i][j]) {
                    emptyboard.add(bfs(i, j, game_board, 0));
                }
            }
        }
        
        List<List<int[]>> blocks = new ArrayList<>();
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (table[i][j] == 1 && !visited[i][j]) {
                    blocks.add(bfs(i, j, table, 1));
                }
            }
        }
        
        //최대 값 넣기
        answer = match(emptyboard, blocks);
        
        return answer;
    }
    
    static int match(List<List<int[]>> board, List<List<int[]>> blocks) {
        
        int count = 0;
        boolean[] used = new boolean[blocks.size()];
        
        for (int i = 0; i < board.size(); i++) {
            List<int[]> target = board.get(i);
            
            for (int j = 0; j < blocks.size(); j++) {
                if (used[j]) continue;
                
                List<int[]> block = blocks.get(j);
                // 회전해가며 확인
                if (compareAndrotate(target, block)) {
                    count += block.size();
                    used[j] = true;
                    break;
                }
            }
        } 
        return count;
    }
    
    static boolean compareAndrotate(List<int[]> board, List<int[]> blocks) {
        
        if (board.size() != blocks.size()) return false;
        
        List<int[]> rotated = blocks;
        for (int i = 0; i < 4; i++) {
            if (compare(board, rotated)) {
                return true;
            }
            rotated = rotate(rotated);
        }
        
        return false;
    }
    
    static boolean compare(List<int[]> board, List<int[]> blocks) {
        Collections.sort(board, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        
        Collections.sort(blocks, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        
        for (int i = 0; i < board.size(); i++) {
            int[] bd = board.get(i);
            int[] bk = blocks.get(i);
            
            if (bd[0] != bk[0] || bd[1] != bk[1]) return false;
        }
        
        return true;
        
    }
    
    static List<int[]> rotate(List<int[]> blocks) {
        List<int[]> result = new ArrayList<>();
        
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        
        for (int[] block : blocks) {
            int x = block[1];
            int y = -block[0];
            
            result.add(new int[] {x, y});
            
            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
        }
        
        for (int[] space : result) {
            space[0] -= minX;
            space[1] -= minY;
        }
        
        return result;
    }
    
    static List<int[]> bfs(int sx, int sy, int[][] board, int target) {
        List<int[]> result = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {sx, sy});
        
        int row = board.length;
        int col = board[0].length;
        
        visited[sx][sy] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            result.add(current);
            
            int x = current[0];
            int y = current[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (0 <= nx && nx < row && 0 <= ny && ny < col && !visited[nx][ny] && board[nx][ny] == target) {
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
        
        return formatting_block(result);
    }
    
    static List<int[]> formatting_block(List<int[]> blocks) {
        
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        
        for (int[] block : blocks) {
            minX = Math.min(minX, block[0]);
            minY = Math.min(minY, block[1]);
        }
        
        for (int[] block : blocks) {
            block[0] -= minX;
            block[1] -= minY;
        }
        
        return blocks;
    }
    
}