class Solution {
    
    static int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        dfs(numbers, target, 0, 0);
        
        return answer;
    }
    
    static void dfs (int[] numbers, int target, int index, int total) {
        
        if (numbers.length == index) {
            if (total == target) {
                answer += 1;
                return;
            }
            return;
        }
        
        dfs(numbers, target, index + 1, total + numbers[index]);
        dfs(numbers, target, index + 1, total - numbers[index]);
        
        return;
    }
    
}