class Solution {
    
    static int count = 0; 
    static int N;
    
    public int solution(int[] numbers, int target) {
        
        N = numbers.length;
        dfs(numbers, 0, 0, target);
        
        return count;
    }
    
    static void dfs(int[] numbers, int index, int sum, int target) {
        if (numbers.length == index) {
            if (sum == target) {
                count++;
            }
            return;
        }
        
        dfs(numbers, index + 1, sum + numbers[index], target);
        dfs(numbers, index + 1, sum - numbers[index], target);
    }
}