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
            
            // 2x2 블록 탐지
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
            
            // 지울 블록이 없으면 종료
            if (!hasBlocksToRemove) break;
            
            // 블록을 삭제하고 answer에 추가
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) {
                        newBoard[i][j] = "X";
                        answer++;
                    }
                }
            }
            
            // 블록 아래로 내리기
            for (int j = 0; j < n; j++) {
                List<String> column = new ArrayList<>();
                
                // 현재 열의 "X"가 아닌 블록들만 가져오기
                for (int i = m - 1; i >= 0; i--) {
                    if (!newBoard[i][j].equals("X")) {
                        column.add(newBoard[i][j]);
                    }
                }
                
                // 아래에서부터 블록을 채우고 나머지는 "X"로 채우기
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
