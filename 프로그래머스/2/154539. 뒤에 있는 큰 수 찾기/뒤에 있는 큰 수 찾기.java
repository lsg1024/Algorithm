import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = numbers.length - 1; i >= 0; i--) {
            
            // 스택이 비어있지 않거나 num 값이 스택 상단 즉 뒷 값보다 크다면 제거
            while (!stack.empty() && numbers[i] >= stack.peek()) {
                stack.pop();
            }
            
            // 스택이 비어 있지 않은 경우
            if (!stack.empty()) {
                answer[i] = stack.peek();
            }
            
            stack.push(numbers[i]);
        }
        
        return answer;
    }
    
}