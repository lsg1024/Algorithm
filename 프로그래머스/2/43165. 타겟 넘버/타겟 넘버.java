class Solution {
    
    public int count = 0;
    
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, target, 0, 0);
        
        return count;
    }
    
    public void dfs(int[] numbers, int target, int index, int total) {
        
        if (index == numbers.length) {
            if (total == target) {
                count++;
            }
            return;
        }
        
        dfs(numbers, target, index + 1, total + numbers[index]);
        dfs(numbers, target, index + 1, total - numbers[index]);
    }
}