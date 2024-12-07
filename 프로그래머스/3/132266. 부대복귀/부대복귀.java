import java.util.*;

class Solution {
    
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < roads.length; i++) {
            int x = roads[i][0];
            int y = roads[i][1];
            
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        
        visited = new int[n + 1];
        Arrays.fill(visited, -1);
        
        dijkstra(destination);
        
        for (int i = 0; i < sources.length; i++) {
            answer[i] = visited[sources[i]];
        }
        
        return answer;
    }
    
    static void dijkstra(int destination) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[] {destination, 0});
        visited[destination] = 0;
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int index = current[0];
            int cost = current[1];
            
            if (visited[index] < cost) continue;

            for (int nextNode : graph.get(index)) {
                if (visited[nextNode] == -1 || cost + 1 < visited[nextNode]) {
                    visited[nextNode] = cost + 1;
                    pq.offer(new int[] {nextNode, cost + 1});
                }
            }
        }
    }    
}