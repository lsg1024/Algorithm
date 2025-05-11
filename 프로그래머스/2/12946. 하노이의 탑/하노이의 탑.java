import java.util.*;

class Solution {
    public int[][] solution(int n) {
        List<int[]> moves = new ArrayList<>();
        hanoi(n, 1, 3, 2, moves);
        
        int[][] answer = new int[moves.size()][2];
        for (int i = 0; i < moves.size(); i++) {
            answer[i] = moves.get(i);
        }
        
        return answer;
    }
    
    private void hanoi(int n, int from, int to, int via, List<int[]> moves) {
        if (n == 1) {
            moves.add(new int[] {from, to});
            return;
        }
        
        hanoi(n - 1, from, via, to, moves);
        moves.add(new int[] {from, to});
        hanoi(n - 1, via, to, from, moves);
    }
    
}      