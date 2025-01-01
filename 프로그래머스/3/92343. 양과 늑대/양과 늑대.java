import java.util.*;

class Solution {
    
    static boolean[] visited;
    static int answer = 0;
    static int[] info;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    
    public int solution(int[] info, int[][] edges) {
        
        this.info = info;
        
        for (int i=0; i < info.length; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int s = edge[0];
            int e = edge[1];
            
            graph.get(s).add(e);
        }
        
        visited = new boolean[info.length];
        dfs(0, 0, 0, new ArrayList<>(List.of(0)));
        
        return answer;
    }
    
    static void dfs(int sheep, int wolf, int node, List<Integer> nodes) {
        
        if (info[node] == 0) {
            sheep++;
        } else {
            wolf++;
        }
        
        if (sheep <= wolf) {
            return;
        }
        
        answer = Math.max(answer, sheep);
        
        List<Integer> nextNodes = new ArrayList<>(nodes);
        if (!graph.get(node).isEmpty()) {
            nextNodes.addAll(graph.get(node));
        }
        nextNodes.remove(Integer.valueOf(node));
        
        for (int next : nextNodes) {
            dfs(sheep, wolf, next, nextNodes);
        }
        
    }
    
}