import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        long sum = 0;
        long sum_q1 = 0;
        long sum_q2 = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for (int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            sum += queue1[i];
            sum_q1 += queue1[i];
        }
        
        for (int i = 0; i < queue2.length; i++) {
            q2.offer(queue2[i]);
            sum += queue2[i];
            sum_q2 += queue2[i];
        }
        
        if (sum % 2 != 0) {
            return -1;
        }
        
        long max = q1.size() * 4;
        int count = 0;

         while (count < max) {
            
            if (sum_q1 == sum_q2) {
                break;
            }
            
            if (sum_q1 > sum_q2) {
                int move_q2 = q1.poll();
                sum_q1 -= move_q2;
                sum_q2 += move_q2;
                q2.offer(move_q2);
                count++;
            }
            else {
                int move_q1 = q2.poll();
                sum_q2 -= move_q1;
                sum_q1 += move_q1;
                q1.offer(move_q1);
                count++;
            }
            
        }
        
        if (sum_q1 == sum_q2) {
            return count;
        }
        
        return -1;
    }
}