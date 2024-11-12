import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = A.length - 1; i >= 0; i--) {
            
            if (A[i] < B[i]) {
                answer += 1;
            } else {
                queue.offer(B[i]);         
                if (!queue.isEmpty()) {
                    if (queue.peek() > A[i]) {
                        queue.poll();
                        answer += 1;
                    }
                }
            }
        }
        
        return answer;
    }
}