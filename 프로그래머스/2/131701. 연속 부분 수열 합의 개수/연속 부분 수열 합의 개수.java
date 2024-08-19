import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        int size = elements.length;
        HashSet<Integer> hashset = new HashSet<>();
        int[] sum_value = new int[size + 1];
        
        for (int i = 0; i < size; i++) {
            sum_value[i + 1] = sum_value[i] + elements[i];
        }

        for (int length = 1; length <= size; length++) {
            for (int start = 0; start < size; start++) {
                
                int end = length + start;
                
                // 인덱스 범위 사이즈 안넘어갈 때
                if (end <= size) {
                    hashset.add(sum_value[end] - sum_value[start]);
                }
                // 원형 수열 뒷자리 
                else {
                    int sum = (sum_value[size] - sum_value[start]) + (sum_value[end - size]);
                    hashset.add(sum);
                }
            }
        }
        
        return hashset.size();
    }
}