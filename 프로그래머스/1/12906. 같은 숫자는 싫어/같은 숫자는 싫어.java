import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        int[] answer;

        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < arr.length; i++) {
            
            if (stack.isEmpty()) {
                stack.push(arr[i]);
            }
            else {
                int bf_num = stack.peek();
                if (bf_num != arr[i]) {
                    stack.push(arr[i]);
                }
            }
        }
        
        int size = stack.size();
        
        answer = new int[size];
        
        for (int i = size - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}