import java.util.*;

class Food {
    
    int time;
    int index;
    
    public Food(int time, int index) {
        this.time = time;
        this.index = index;
    }
    
}

class Solution {
    public int solution(int[] food_times, long k) {
        int answer = 0;
        long sum = 0;
        int n = food_times.length;
        
        PriorityQueue<Food> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.time - o2.time;
        });
        
        for (int i = 0; i < n; i++) {
            pq.offer(new Food(food_times[i], i + 1));
        }
        
        long previous = 0;
        long length = n;
        
        while (!pq.isEmpty()) {
            long now = pq.peek().time; 
            long diff = now - previous; 
            long spend = diff * length; 
            
            if (k < spend) break; 
            
            k -= spend; 

            previous = now;
            
            pq.poll();
            length--;
        }
        
        if (pq.isEmpty()) return -1;
        
        List<Food> food = new ArrayList<>(pq);
        Collections.sort(food, (a, b) -> a.index - b.index);
        
        return food.get((int)(k % length)).index;
    }
}