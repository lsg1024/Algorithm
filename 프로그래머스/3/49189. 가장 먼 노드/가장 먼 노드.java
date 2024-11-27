import java.util.*;

class Solution {

    static int maxDistance;
    static int[] distance;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        visited = new boolean[n + 1];
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] e : edge) {
            int x = e[0];
            int y = e[1];
            
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        
        bfs();
        
        for (int dis : distance) {
            if (dis == maxDistance) {
                answer++;
            }
        }
        
        return answer;
    }
    
    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        distance= new int[visited.length];
        Arrays.fill(distance, -1);
        
        q.offer(1);
        visited[1] = true;
        distance[1] = 1;
        
        maxDistance = 1;
        
        while (!q.isEmpty()) {
            int current = q.poll();
            
            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[current] + 1;
                    maxDistance = Math.max(maxDistance, distance[next]);
                    q.offer(next);
                }
            }
        }
    }
}