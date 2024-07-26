import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        int colum = col - 1;
        Arrays.sort(data, (o1, o2) -> {
            if (o1[colum] == o2[colum]) {
                return o2[0] - o1[0];
            }
            return o1[colum] - o2[colum];
                
        });
        
        for (int i = row_begin; i <= row_end; i++) {
            int after = 0;
            for (int j = 0; j < data[0].length; j++) {
                after += data[i - 1][j] % i;
            }
            answer ^= after;
        }
        
        return answer;
    }
}