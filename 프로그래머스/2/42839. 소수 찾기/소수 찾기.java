import java.util.*;

class Solution {
    
    HashSet<Integer> hashset = new HashSet<>();
    boolean[] visited;
    
    public int solution(String numbers) {
        int answer = 0;
        
        visited = new boolean[numbers.length()];
        
        dfs(numbers, "", 0);
        
        for (Integer num : hashset) {
            if (isPrime(num)) {
                answer+=1;
            }
        }
        
        return answer;
    }
    
    public void dfs(String numbers, String bf_s, int depth) {
        
        if (depth > numbers.length()) {
            return;
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                hashset.add(Integer.parseInt(bf_s + numbers.charAt(i)));
                dfs(numbers, bf_s + numbers.charAt(i), depth + 1);
                visited[i] = false;
            }
        }
        
    }
    
    public boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        else if (number == 2) {
            return true;
        }
        for (int i = 2; i <= (int) Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}