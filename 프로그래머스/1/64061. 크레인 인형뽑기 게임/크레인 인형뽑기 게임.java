import java.util.*;

class Solution {
    
    static int count = 0;
    static Stack<Integer> stack = new Stack<>();
    
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        for (int move : moves) {
            find(board, move);
            
        }
        
        return count;
    }
    
    
    static void find(int[][] board, int move) {
        
        for (int i = 0; i < board.length; i++) {
            int number = board[i][move - 1];
    
            if (number != 0) {
                board[i][move - 1] = 0;  
                
                if (!stack.isEmpty() && stack.peek() == number) {
                    stack.pop(); 
                    count += 2;
                } else {
                    stack.push(number);
                }
                break;
            }
        }
        
        return;
        
    }
    
}