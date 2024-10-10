import java.util.*;

class Solution {
    
    static HashMap<String, List<Integer>> infoMap = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        for (String inf : info) {
            String[] parts = inf.split(" ");
            infoInsert(parts, 0, "");
        }
        
        for (String key : infoMap.keySet()) {
            Collections.sort(infoMap.get(key));
        }
        
        for (int i = 0; i < query.length; i++) {
            String q = query[i].replaceAll(" and ", " ");
            String[] qpart = q.split(" ");
            String key = "";
            for (int j = 0; j < qpart.length - 1; j++) {
                key += qpart[j];
            }
            
            int score = Integer.parseInt(qpart[qpart.length - 1]);
            
            if (infoMap.containsKey(key)) {
                List<Integer> scores = infoMap.get(key);
                answer[i] = lowScore(scores, score);
            } else {
                answer[i] = 0;
            }
        }
        
        return answer;
    }
    
    static int lowScore(List<Integer> scores, int target) {
        int low = 0;
        int high = scores.size();
        
        while (low < high) {
            int mid = (low + high) / 2;
            
            if (scores.get(mid) >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return scores.size() - low;
    }
    
    static void infoInsert(String[] parts, int idx, String key) {
        
        if (idx == 4) {
            if(!infoMap.containsKey(key)){
                infoMap.put(key, new ArrayList<>());
            }
            infoMap.get(key).add(Integer.parseInt(parts[4]));
            return;
        }
        
        // 해당 조건을 포함하거나, 와일드카드 '-'를 포함하는 두 가지 경우
        infoInsert(parts, idx + 1, key + parts[idx]);
        infoInsert(parts, idx + 1, key + "-");
    }
    
}