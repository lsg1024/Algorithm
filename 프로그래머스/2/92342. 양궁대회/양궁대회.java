class Solution {

    static int[] lion_info, answer;
    static int MAX_SCORE = Integer.MIN_VALUE;
    
    public int[] solution(int n, int[] info) {
        answer = new int[] { -1 };
        
        lion_info = new int[11];
        
        dfs(info, 1, n);
        
        return answer;
    }
    
    static void dfs(int[] info, int arrows, int n) {
        
        if (arrows == n + 1) {
            int apeach_score = 0;
            int lion_score = 0;     
            for (int i = 0; i < 11; i++) {
                
                if (info[i] == 0 && lion_info[i] == 0) continue;
                
                if (info[i] < lion_info[i]) lion_score += 10 - i;
                
                else apeach_score += 10 - i;
            }
            
            // lion_score가 apeach_score보다 크고 MAX_VALUE 보다 크면 갱신
            if (lion_score > apeach_score) {
                if (lion_score - apeach_score > MAX_SCORE) {
                    MAX_SCORE = lion_score - apeach_score;
                    answer = lion_info.clone();
                } else if (lion_score - apeach_score == MAX_SCORE) {
                    // 점수 차이가 같은 경우, 더 낮은 점수를 많이 맞힌 경우를 선택
                    if (compareLowerScores()) {
                        answer = lion_info.clone();
                    }
                }
            }
            return;
        }
        
        // 화살을 쏴 점수 계산
        for (int i = 0; i <= 10 && lion_info[i] <= info[i]; i++) {
            lion_info[i]++;
            dfs(info, arrows + 1, n);
            lion_info[i]--;
        }
    }

    static boolean compareLowerScores() {
        for (int i = 10; i >= 0; i--) {
            if (lion_info[i] > answer[i]) return true; 
            else if (lion_info[i] < answer[i]) return false; 
        }
        return false;
    }
    
}
