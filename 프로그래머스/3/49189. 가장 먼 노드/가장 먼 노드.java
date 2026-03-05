import java.util.*;

class Solution {
    
    static int maxWeight = 0;
    static int totalCount = 0;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edge.length; i++) {
            int x = edge[i][0];
            int y = edge[i][1];
            
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        
        answer = bfs(n);
          
        return answer;
    }
    
    static int bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);
        distances[1] = 1;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
               
            for (int next : graph.get(node)) {
                if (distances[next] == -1) {
                    distances[next] = distances[node] + 1;
                    queue.add(next);
                }
            }
        }
        
        int maxValue = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            maxValue = Math.max(distances[i], maxValue);
        }
        
        for (int i = 1; i <= n; i++) {
            if (distances[i] == maxValue) {
                count++;
            }
        }
        
        return count;
        
    }
    
}