class Solution {
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int x = board[0].length;
        int y = board.length;
        
        String targetColor = board[h][w];
        
        if (h + 1 < y && board[h + 1][w].equals(targetColor))answer++;
        
        if (h - 1 >= 0 && board[h - 1][w].equals(targetColor)) answer++;
        
        if (w + 1 < x && board[h][w + 1].equals(targetColor)) answer++;
        
        if (w - 1 >= 0 && board[h][w - 1].equals(targetColor)) answer++;
        
        return answer;
    }

}