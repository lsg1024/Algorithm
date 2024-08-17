import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        int index = 0;
        for (int i = 1; i <= order.length; i++) {

            if (order[index] == i) {
                index++;
                answer++;
            }
            else {
                stack.push(i);
            }   
            
            while (!stack.isEmpty() && stack.peek() == order[index]) {
                    index++;
                    stack.pop();
                    answer++;
            }

        }
                
        return answer;
    }
}
