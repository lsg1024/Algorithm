import java.util.*;

class Solution {
    
    static List<List<Integer>> graph = new ArrayList<>();
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];
            
            graph.get(winner).add(loser);
        }
  
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph.get(i).contains(k) && graph.get(k).contains(j)) {
                        if (!graph.get(i).contains(j)) {
                            graph.get(i).add(j);
                        }
                    }
                }
            }
        }
        
      for (int i = 1; i <= n; i++) {
            Set<Integer> reachable = new HashSet<>(graph.get(i));
            for (int j = 1; j <= n; j++) {
                if (graph.get(j).contains(i)) {
                    reachable.add(j);
                }
            }
            
            if (reachable.size() == n - 1) {
                answer++;
            }
        }
        
        return answer;
    }
}