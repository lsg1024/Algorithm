class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;
        
        if (n <= cores.length) return n;
        
        int low = 0;
        int high = 100000;
        int time = 0;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            int count = func(mid, cores);
            
            if (count >= n) {
                high = mid -1;
                time = mid;
            } else {
                low = mid + 1;
            }
        }

        int worksBefore = func(time - 1, cores);
        int work = n - worksBefore;
        
        for (int i = 0; i < cores.length; i++) {
            if (time % cores[i] == 0) {
                work--;
                if (work == 0) return i + 1; 
            }
        }
        
        return answer;
    }
    
    static int func(int mid, int[] cores) {
        int count = cores.length;
        
        for (int i = 0; i < cores.length; i++) {
            count += mid / cores[i];
        }
        
        return count;
    }
}