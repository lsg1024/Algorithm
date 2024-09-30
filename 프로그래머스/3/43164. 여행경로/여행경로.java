import java.util.*;

class Solution {
    private Map<String, PriorityQueue<String>> graph = new HashMap<>();
    private LinkedList<String> path = new LinkedList<>();

    public String[] solution(String[][] tickets) {
        // 그래프 구축: 각 출발지에서 도착지를 알파벳 순으로 정렬된 우선순위 큐에 저장
        for (String[] ticket : tickets) {
            graph.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
        }

        // "ICN"에서 출발하여 경로 탐색
        dfs("ICN");

        // LinkedList를 배열로 변환하여 반환
        return path.toArray(new String[0]);
    }

    private void dfs(String current) {
        PriorityQueue<String> destinations = graph.get(current);
        while (destinations != null && !destinations.isEmpty()) {
            String next = destinations.poll();
            dfs(next);
        }
        // 모든 경로를 탐색한 후 경로에 추가
        path.addFirst(current);
    }
}
