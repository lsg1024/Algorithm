import java.util.*;

class Solution {
    
    int answer;
    int[] a;
    int[][] Q;
    List<Integer> numbers = new ArrayList<>();
    
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        
        a = ans;
        Q = q;
        
        dfs(n, 1, 0);
        
        return answer;
    }
    
    public void dfs(int n, int start, int depth) {
        if (depth == 5) {
            if (check(numbers)) answer++;
            return;
        }
        
        for (int i = start; i <= n; i++) {
            numbers.add(i);
            dfs(n, i + 1, depth + 1);
            numbers.remove(numbers.size() - 1);
        }
        
    }
    
    public boolean check(List<Integer> numbers) {
        for (int i = 0; i < Q.length; i++) {
            int cnt = 0;
            for (int j = 0; j < Q[i].length; j++) {
                for (int number : numbers) {
                    if (number == Q[i][j]) cnt++;
                }
            }
            
            if (cnt != a[i]) {
                return false;
            }
            
        }
        return true;
    }
    
}