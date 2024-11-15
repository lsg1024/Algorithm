import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int answer = 0;

        if (sticker.length == 1) {
            return sticker[0];
        } else if (sticker.length == 2) {
            return sticker[1] > sticker[0] ? sticker[1] : sticker[0];
        }
        
        int[] dp_1 = new int[sticker.length - 1];
        
        dp_1[0] = sticker[0];
        dp_1[1] = sticker[0];
        
        for (int i = 2; i < sticker.length - 1; i++) {
            dp_1[i] = Math.max(dp_1[i - 1], dp_1[i - 2] + sticker[i]);
        }
        
        int[] dp_2 = new int[sticker.length];
        dp_2[0] = 0;
        dp_2[1] = sticker[1];
        
        for (int i = 2; i < sticker.length; i++) {
            dp_2[i] = Math.max(dp_2[i - 1], dp_2[i - 2] + sticker[i]);
        }

        return Math.max(dp_1[dp_1.length - 1], dp_2[dp_2.length - 1]);
    }
}