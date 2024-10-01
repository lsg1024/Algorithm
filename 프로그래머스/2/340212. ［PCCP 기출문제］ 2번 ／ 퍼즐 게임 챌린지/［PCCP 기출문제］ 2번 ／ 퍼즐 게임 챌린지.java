class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer;
        
        int right = 0;
        int left = 1;
        
        for (int diff : diffs) {
            if (diff > right) {
                right = diff;
            }
        }
        
        answer = right;
        
        
        while (left <= right) {
            
            int mid = (right + left) / 2;
            long total_time = dfs(mid, diffs, times, limit);
            
            if (total_time <= limit) {
                answer = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
    
        }    
        
        return answer;
    }
    
    static long dfs(int level, int[] diffs, int[] times, long limit) {
        
        long result = 0L;
        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                result += times[i];
            }
            else {
                if (i == 0) {
                    result += times[i] * (diffs[i] - level) + times[i];
                } else {
                    result += (times[i] + times[i - 1]) * (diffs[i] - level) + times[i];
                }
            }
            
            if (result > limit) {
                break;
            }
        }
        
        return result;
    }
    
}