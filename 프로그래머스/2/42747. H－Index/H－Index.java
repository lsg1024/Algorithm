import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        int n = citations.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = citations[i];
            citations[i] = citations[n - 1 - i];
            citations[n - 1 - i] = temp;
        }
        
        int h = 0;
        for (int i = 0; i < n; i++) {
            if (citations[i] >= i + 1) {
                h = i + 1;
            }
        }
        
        return h;
    }
}