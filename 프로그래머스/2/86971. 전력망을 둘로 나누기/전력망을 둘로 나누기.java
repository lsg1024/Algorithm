import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] wire : wires) {
            int w1 = wire[0];
            int w2 = wire[1];
            
            graph.get(w1).add(w2);
            graph.get(w2).add(w1);
            
        }
        
        for (int[] wire : wires) {
            int w1 = wire[0];
            int w2 = wire[1];
            
            graph.get(w1).remove(Integer.valueOf(w2));
            graph.get(w2).remove(Integer.valueOf(w1));
            
            boolean[] visited = new boolean[n + 1];
            int node_size = dfs(w1, graph, visited);
            
            int diff = Math.abs((n - node_size) - node_size);
            answer = Math.min(answer, diff);
            
            graph.get(w1).add(w2);
            graph.get(w2).add(w1);
            
        }
        
        return answer;
    }
    
    static int dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        int count = 1;
        
        for (int next_node : graph.get(node)) {
            if (!visited[next_node]) {
                count += dfs(next_node, graph, visited);
            } 
        }
        
        return count;
    }
    
}