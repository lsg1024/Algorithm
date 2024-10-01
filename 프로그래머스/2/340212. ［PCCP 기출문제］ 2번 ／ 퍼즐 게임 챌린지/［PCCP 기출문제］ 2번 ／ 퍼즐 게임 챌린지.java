class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int left = 1;
        int right = 0;
        
        for (int diff : diffs) {
            if (diff > right) {
                right = diff;
            }
        }
        
        answer = right;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            long total_time = binarySearch(mid, diffs, times, limit);
            
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
    
    static long binarySearch(int mid, int[] diffs, int[] times, long limit) {
        
        long total_time = 0;
        for (int i = 0; i < diffs.length; i++) {
            if (mid >= diffs[i]) {
                total_time += times[i];
            }
            else {
                int again = diffs[i] - mid;
                if (i == 0) {
                    total_time += again * times[i] + times[i];
                }
                else {
                    total_time += again * (times[i] + times[i - 1]) + times[i];
                }
            }
            
            if (total_time > limit) {
                break;
            }
        }
        
        return total_time;
        
    }
}