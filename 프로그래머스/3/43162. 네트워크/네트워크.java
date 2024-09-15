class Solution {
    
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(n, computers,i);
            }
        }
        
        return answer;
    }
    
    static void dfs(int n, int[][] computers, int index) {
        
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i] && computers[index][i] == 1) {
                visited[index] = true;
                dfs(n, computers, i);
            }
        }
        
    }
    
}