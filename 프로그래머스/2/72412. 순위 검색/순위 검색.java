import java.util.*;

class Solution {
    
    static HashMap<String, List<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        for (int i = 0; i < info.length; i++) {
            String[] infos = info[i].split(" ");
            int score = Integer.parseInt(infos[4]);
            
            makeInfo(infos, "", 0, score);
        }
        
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }
        
        for (int i = 0; i < query.length; i++) {
            String[] q = query[i].replaceAll(" and", "").split(" ");
            String key = q[0] + q[1] + q[2] + q[3];
            int targetScore = Integer.parseInt(q[4]);
            
            if (!map.containsKey(key)) {
                answer[i] = 0;
                continue;
            }
            
            List<Integer> scores = map.get(key);
            answer[i] = scores.size() - getTargetScore(scores, targetScore);
            
        }
        
        return answer;
    }
    
    static void makeInfo(String[] info, String current, int depth, int score) {
        
        if (depth == 4) {
            if (!map.containsKey(current)) {
                map.put(current, new ArrayList<>());
            }
            map.get(current).add(score);
            return;
        }
        

        
        makeInfo(info, current + info[depth], depth + 1, score);
        
        makeInfo(info, current + "-", depth + 1, score);
   
    }
    
    static int getTargetScore(List<Integer> scores, int targetScore) {
        int left = 0;
        int right = scores.size();
        
        while (left < right) {
            int mid = (left + right) / 2;
            
            if (scores.get(mid) >= targetScore) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
}