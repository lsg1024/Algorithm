import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Arrays.sort(weights);
        HashMap<Double, Integer> weightMap = new HashMap<>();
        
        for(int weight : weights) {
            double a = (double) weight;
            double b = (double) (weight * 2.0) / 3.0;
            double c = (double) weight / 2.0;
            double d = (double) (weight * 3.0) / 4.0;
            
            if (weightMap.containsKey(a)) {
                answer += weightMap.get(a);
            }
            if (weightMap.containsKey(b)) {
                answer += weightMap.get(b);
            }
            if (weightMap.containsKey(c)) {
                answer += weightMap.get(c);
            }
            if (weightMap.containsKey(d)) {
                answer += weightMap.get(d);
            }
            
            weightMap.put(a, weightMap.getOrDefault(a, 0) + 1);
            
        }
        
        return answer;
    }
}