import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        
        for (int i = 1; i <= order.length; i++) {
            if (order[index] != i) {
                stack.push(i);
            }
            else {
                index++;
                answer++;
            }
            
            while (!stack.isEmpty() && stack.peek() == order[index]) {
                stack.pop();
                answer++;
                index++;
            }
        }

        return answer;
    }
}
