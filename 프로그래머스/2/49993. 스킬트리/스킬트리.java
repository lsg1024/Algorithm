import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        Queue<Character> queue = new LinkedList<>();
        
        for (int i = 0; i < skill.length(); i++) {
            queue.offer(skill.charAt(i));
        }
        
        for (String skill_tree : skill_trees) {
            
            Queue<Character> queue_copy = new LinkedList<>(queue);
            boolean bool = true;
            for (int i = 0; i < skill_tree.length(); i++) {
            
                char skill_w = skill_tree.charAt(i);
                // 스택에 값이 있는 경우 순서에 맞게 있는지
                if (queue_copy.contains(skill_w)) {
                    if (!queue_copy.peek().equals(skill_w)) {
                        bool = false;
                        break;
                    }
                    queue_copy.poll();
                }
                
            }
            
            if (bool) {
                answer++;
            }
            
        }
        
        return answer;
    }
}