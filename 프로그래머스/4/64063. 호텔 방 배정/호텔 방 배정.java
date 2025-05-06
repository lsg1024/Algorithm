import java.util.*;

class Solution {
    
    HashMap<Long, Long> room = new HashMap<>();
    
    public long[] solution(long k, long[] room_number) {
        int n = room_number.length;
        long[] answer = new long[n];
        
        for (int i = 0; i < n; i++) {
            answer[i] = find(room_number[i]);
        }
        
        return answer;
    }
    
    public long find(long room_number) {
        if (!room.containsKey(room_number)) {
            room.put(room_number, room_number + 1);
            return room_number;
        } else {
            long empty_room = find(room.get(room_number));
            room.put(room_number, empty_room);
            return empty_room;
        }
    }
    
}