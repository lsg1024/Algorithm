import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        // 각 무게의 빈도수를 저장할 맵
        HashMap<Integer, Integer> weightMap = new HashMap<>();
        for (int weight : weights) {
            weightMap.put(weight, weightMap.getOrDefault(weight, 0) + 1);
        }

        // 가능한 비율 목록
        double[] ratios = {1.0, 1.5, 2.0, 0.6666666666666666, 1.3333333333333333, 0.5, 0.75};

        // 모든 고유 무게를 리스트로 변환
        List<Integer> uniqueWeights = new ArrayList<>(weightMap.keySet());

        for (int w1 : uniqueWeights) {
            int freq1 = weightMap.get(w1);
            for (double r : ratios) {
                double w2Double = w1 / r;

                // w2가 정수인지 확인
                if (w2Double != Math.floor(w2Double)) {
                    continue;
                }

                int w2 = (int) w2Double;

                // w2가 맵에 존재하는지 확인
                if (weightMap.containsKey(w2)) {
                    int freq2 = weightMap.get(w2);

                    if (w1 < w2) {
                        answer += (long) freq1 * freq2;
                    } else if (w1 == w2 && r == 1.0) {
                        // 동일한 무게이면서 비율이 1인 경우 조합 계산
                        answer += ((long) freq1 * (freq1 - 1)) / 2;
                    }
                    // w1 > w2인 경우는 이미 (w2, w1)에서 계산되었으므로 무시
                }
            }
        }

        return answer;
    }
}
