import java.util.*;

class Solution {
    static int answer = 0;
    static String[][] newBoard;
    static boolean[][] visited;
    
    public int solution(int m, int n, String[] board) {
        newBoard = new String[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newBoard[i][j] = String.valueOf(board[i].charAt(j));
            }
        }
        
        while (true) {
            visited = new boolean[m][n];
            boolean hasBlocksToRemove = false;
            
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    String target = newBoard[i][j];
                    if (!target.equals("X") && target.equals(newBoard[i][j + 1]) 
                        && target.equals(newBoard[i + 1][j]) && target.equals(newBoard[i + 1][j + 1])) {
                        
                        visited[i][j] = true;
                        visited[i][j + 1] = true;
                        visited[i + 1][j] = true;
                        visited[i + 1][j + 1] = true;
                        hasBlocksToRemove = true;
                    }
                }
            }

            if (!hasBlocksToRemove) break;
            
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) {
                        newBoard[i][j] = "X";
                        answer++;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                List<String> column = new ArrayList<>();

                for (int i = m - 1; i >= 0; i--) {
                    if (!newBoard[i][j].equals("X")) {
                        column.add(newBoard[i][j]);
                    }
                }

                for (int i = 0; i < m; i++) {
                    if (i < column.size()) {
                        newBoard[m - 1 - i][j] = column.get(i);
                    } else {
                        newBoard[m - 1 - i][j] = "X";
                    }
                }
            }
        }
        
        return answer;
    }
}
