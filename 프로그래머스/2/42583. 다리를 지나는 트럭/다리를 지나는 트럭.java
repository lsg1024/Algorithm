import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int totalWeight = 0;
        int index = 0;
        
        Queue<int[]> move_truck = new LinkedList<>();
        
        while (index < truck_weights.length || !move_truck.isEmpty()) {
            
            answer++;
            
            if (!move_truck.isEmpty() && move_truck.peek()[1] == 0) {
                
                totalWeight -= move_truck.poll()[0];

            }
            
            if (index < truck_weights.length && totalWeight + truck_weights[index] <= weight) {
                move_truck.offer(new int[] {truck_weights[index], bridge_length});
                totalWeight += truck_weights[index];
                index++;
            }
            
            for (int[] truck : move_truck) {
                truck[1]--;
            }
            
        }
        
        return answer;
    }
}