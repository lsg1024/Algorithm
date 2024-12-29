class Solution {
    public int[] solution(long begin, long end) {
        
        int length = (int) (end - begin + 1);
        int[] answer = new int[length];
        
        int index = 0;
        for (int i = (int) begin; i <= (int) end; i++) {
            answer[index++] = getSmallestBlock(i);
        }
        
        return answer;
    }
    
    private int getSmallestBlock(int num) {
        
        if (num == 1) {
            return 0;
        }
        
        int result = 1;
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                int block = num / i;
                if (block <= 10_000_000) {
                    result = Math.max(result, block);
                    break;
                } else {
                    result = Math.max(result, i);
                }
            }
        }
        return result; 
    }
}