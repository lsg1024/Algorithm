import java.util.*;

class Word {
    String word;
    int count;
    
    public Word(String word, int count) {
        this.word = word;
        this.count = count;
    }
    
}

class Solution {
    
    static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }
        
        for (int i = 0; i < words.length; i++) {
            answer = bfs(begin, target, words);
        }
        
        return answer;
    }
    
    // 이미 안되는건 걸렀으니깐 최단 경로로 단어 변환 수 세기
    static int bfs(String begin, String target, String[] words) {
        Queue<Word> queue = new LinkedList<>();
        queue.offer(new Word(begin, 0));
        visited = new boolean[words.length];
        
        while (!queue.isEmpty()) {
            Word data = queue.poll();
            
            if (data.word.equals(target)) {
                return data.count;
            }
            
            for (int i = 0; i < words.length; i++) {
                // Word.word와 1개 다른 값들을 주입 = true 반환
                if (!visited[i] && check(data.word, words[i])) {
                    queue.offer(new Word(words[i], data.count + 1));
                    visited[i] = true;
                }
            }
            
        }
        
        return 0;
        
    }
    
    static boolean check(String start, String end) {
        
        int cnt = 0;
        
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == end.charAt(i)) {
                cnt++;
            }
        }
        
        // 값이 1라면 변환 가능한 단어
        return cnt == start.length() - 1 ? true : false;
    }
    
}