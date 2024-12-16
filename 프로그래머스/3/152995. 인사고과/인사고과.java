import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] wanho = scores[0];
        int rank = 1;
        int maxScore = 0;
        int wanhoTotal = wanho[0] + wanho[1];
        
        Arrays.sort(scores, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        
        for (int[] score : scores) {
            if (maxScore <= score[1]) {
                maxScore = score[1];
                if (score[0] + score[1] > wanhoTotal) rank++;
            } else {
                if (score.equals(wanho)) return -1;
            }
        }
        
        return rank;
    }
}