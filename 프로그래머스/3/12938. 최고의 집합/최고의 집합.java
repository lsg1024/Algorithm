import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer;
        
        if (s == 1 || n > s) {
            return new int[] {-1};
        }
        
        int size = n;
        answer = new int[n];
        
        for (int i = 0; i < size; n--, i++) {
            int value = s / n;
            answer[i] = value;
            s -= value;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}