class Solution {
    public int solution(String[] board) {
        
        int countO = 0, countX = 0;
        for (String row : board) {
            for (char cell : row.toCharArray()) {
                if (cell == 'O') countO++;
                else if (cell == 'X') countX++;
            }
        }
        
        if (countO < countX || countO > countX + 1) {
            return 0;
        }
        
        boolean O = isWinner(board, 'O');
        boolean X = isWinner(board, 'X');
        
        if (O && X) {
            return 0;
        }
        
        if (O && countO != countX + 1) {
            return 0;
        }
        
        if (X && countX != countO) {
            return 0;
        }
        
        
        return 1;
    }
    
    static boolean isWinner(String[] board, char player) {
        
        for (int i = 0; i < 3; i++) {
            
            //가로
            if (board[i].charAt(0) == player && board[i].charAt(1) == player && board[i].charAt(2) == player) {
                return true;
            }
            
            //세로
            if (board[0].charAt(i) == player && board[1].charAt(i) == player && board[2].charAt(i) == player) {
                return true;
            }
            
        }
        
        //대각선
        if (board[0].charAt(0) == player && board[1].charAt(1) == player && board[2].charAt(2) == player) {
            return true;
        }
        
        if (board[0].charAt(2) == player && board[1].charAt(1) == player && board[2].charAt(0) == player) {
            return true;
        }
        
        return false;
        
    }
    
}