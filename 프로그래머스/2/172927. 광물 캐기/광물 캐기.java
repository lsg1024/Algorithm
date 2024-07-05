import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int n = minerals.length;
        int cnt = Math.min(minerals.length / 5 + 1, picks[0] + picks[1] + picks[2]);
        
        System.out.println(minerals.length / 5 + 1);
        System.out.println(cnt);
        
        int[][] fatigue = {
            {1, 1, 1},    // 다이아몬드 곡괭이
            {5, 1, 1},    // 철 곡괭이
            {25, 5, 1}    // 돌 곡괭이
        };
        
        // 광물을 5개씩 묶음으로 피로도 계산
        List<int[]> groups = new ArrayList<>();
        for (int i = 0; i < n; i += 5) {
            System.out.println("i = " + i);
            if (i / 5 == cnt) {
                break;
            }
            
            int[] group = new int[3];
            
            // 미네랄 최대 범위 넘어가면 안됨
            for (int j = i; j < i + 5; j++) {
                
                String mineral = minerals[j];
                
                int mineralIndex = 0;
                
                if (mineral.equals("iron")) {
                    mineralIndex = 1;
                }
                else if (mineral.equals("stone")) {
                    mineralIndex = 2;
                }
                
                group[0] += fatigue[0][mineralIndex]; // 다이아
                group[1] += fatigue[1][mineralIndex]; // 철
                group[2] += fatigue[2][mineralIndex]; // 돌
                
                if(j==minerals.length - 1){
                    break;
                }
            }
            groups.add(group);
        }
        
       for (int[] group : groups) {
            for (int v : group) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
        
        // 그룹을 피로도 내림차순으로 정렬
        groups.sort((o1, o2) -> {
            return Integer.compare(o2[2], o1[2]);
        });
        
        System.out.println("+++++++");
        
        for (int[] group : groups) {
            for (int v : group) {
                System.out.print(v + " ");
            }
            System.out.println();
        }

        
        // 각 곡괭이를 사용하여 피로도 계산
        for (int[] group : groups) {
            if (picks[0] != 0) {
                answer += group[0];
                picks[0]--;
            } else if (picks[1] != 0) {
                answer += group[1];
                picks[1]--;
            } else if (picks[2] != 0) {
                answer += group[2];
                picks[2]--;
            }
        }
        
        return answer;
    }
}
