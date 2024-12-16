import java.util.*;

class Solution {
    
    static class Node {
        int index;
        int cost;
        
        Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
    
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int[] visited;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i <= n; i++) {
            graph.add(i, new ArrayList<>());
        }
        
        for (int[] fare : fares) {
            int start = fare[0];
            int end = fare[1];
            int cost = fare[2];
            
            graph.get(start).add(new Node(end, cost));
            graph.get(end).add(new Node(start, cost));
        }
        
        int[] visited_S = new int[n + 1];
        int[] visited_A = new int[n + 1];
        int[] visited_B = new int[n + 1];
        
        visited_S = dijkstra(s, n);
        visited_A = dijkstra(a, n);
        visited_B = dijkstra(b, n);
        
        for (int i = 1; i <= n; i++) {
            if (visited_S[i] != Integer.MAX_VALUE && visited_A[i] != Integer.MAX_VALUE && visited_B[i] != Integer.MAX_VALUE) {
                answer = Math.min(visited_S[i] + visited_A[i] + visited_B[i], answer);
            }
        }
        
        return answer;
    }
    
    static int[] dijkstra(int start, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.cost - o2.cost;
        });
        
        pq.offer(new Node(start, 0));
        
        visited = new int[n + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[start] = 0;
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int index = current.index;
            int cost = current.cost;
            
            if (visited[index] < cost) continue;
            
            for (Node next : graph.get(index)) {
                int next_index = next.index;
                int next_cost = next.cost + cost;
                
                if (visited[next_index] > next_cost) {
                    visited[next_index] = next_cost;
                    pq.offer(new Node(next_index, next_cost));
                }
            }
        }
        
        return visited;
        
    }
    
}