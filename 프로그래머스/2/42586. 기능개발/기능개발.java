import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        
        ArrayList<Integer> arr = new ArrayList<>();
        int last_day = 0;
        
        for (int i = 0; i < progresses.length; i++) {
            int ramainWork = 100 - progresses[i];
            int speed = speeds[i];
            
            int use_day = (int) Math.ceil((double) ramainWork / speed);
            
            if (i == 0 || use_day > last_day) {
                arr.add(1);
                last_day = use_day;
            }
            else {
                int last_dayIndex = arr.size() - 1;
                arr.set(last_dayIndex, arr.get(last_dayIndex) + 1);
            }
            
        }
        
        answer = arr.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}