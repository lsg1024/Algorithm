import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        
        int size = a.length;
        int[] left = new int[size];
        int[] right = new int[size];
        
        left[0] = Integer.MAX_VALUE;
        left[1] = a[0];
        right[size - 1] = Integer.MAX_VALUE;
        right[size - 2] = a[size - 1];
        
        for (int i = 2; i < size; i++) {
            left[i] = Math.min(a[i - 1], left[i - 1]);
            right[size - (i + 1)] = Math.min(right[size - i], a[size - i]);
        }
        
        for (int i = 0; i < size; i++) {
            int min_left = left[i];
            int min_right = right[i];
            
            if (a[i] > min_left && a[i] > min_right) {
                continue;
            }
            
            answer++;
        }
        
        return answer;
    }
}