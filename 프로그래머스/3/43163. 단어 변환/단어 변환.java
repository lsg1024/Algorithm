import java.util.*;

class Solution {
    
    static int answer = Integer.MAX_VALUE;
    static int target_index = Integer.MAX_VALUE;
    static List<List<Integer>> graph = new ArrayList<>();
    
    public int solution(String begin, String target, String[] words) {

        graph.clear();
        answer = Integer.MAX_VALUE;
        target_index = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            graph.add(new ArrayList<>());
        }
        
        // target index 찾기
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                target_index = i;
            }
        }
        
        // target 없으면 0
        if (target_index == Integer.MAX_VALUE) {
            return 0;
        }
        
        // 그래프 생성 (한 글자 차이만 연결)
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                
                int count = 0;
                
                for (int k = 0; k < words[i].length(); k++) {
                    if (words[i].charAt(k) != words[j].charAt(k)) {
                        count++;
                    }
                    if (count > 1) break;
                }
                
                if (count == 1) {  // 수정 부분
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        
        // begin과 직접 연결되는 단어만 BFS 시작
        for (int i = 0; i < words.length; i++) {
            
            int count = 0;
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) != words[i].charAt(j)) {
                    count++;
                }
                if (count > 1) break;
            }
            
            if (count == 1) {   // 수정 부분
                find(i, words);
            }
        }
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    static void find(int index, String[] words) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {index, 1});
        boolean[] visited = new boolean[words.length];
        visited[index] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int depth = current[1];
            
            if (x == target_index) {
                answer = Math.min(answer, depth);
                return;  // BFS 특성상 여기서 종료
            }

            for (int i = 0; i < graph.get(x).size(); i++) {
                Integer next_index = graph.get(x).get(i);
                
                if (!visited[next_index]) {
                    visited[next_index] = true;
                    queue.add(new int[] {next_index, depth + 1});
                }
            }
        }
    }
}