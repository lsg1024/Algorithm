class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        if (s.length() == 1) {
            return 1;
        }
        
        int count = 1;
        int n = s.length() / 2;
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            String base = s.substring(0, i);
            for (int j = i; j <= s.length(); j+=i) {
                int end = Math.min(i + j, s.length());
                String target = s.substring(j, end);
                
                if (base.equals(target)) { // 한번이라도 같은 경우에 sb에 추가
                    count++;
                } else {
                    if (count >= 2) { // 2이상이면 압축이 가능한 단계
                        sb.append(count);
                    }
                    sb.append(base);
                    base = target;
                    count = 1;
                }
            }
            sb.append(base);
            answer = Math.min(answer, sb.length());
        }   
        
        return answer;
    }
}

// 2a2ba2c -> 7
// 2ab2dc2ab2dc -> 2ababcdcd -> 9
// stack -> 어짜피 1000개 여도 절반 초과되서 같을 수 없음 1~n/2까지 반복
// StringBuilder로 삽입