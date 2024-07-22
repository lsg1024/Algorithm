import java.util.*;


// storey 민수와 엘리베이터가 있는 위치
// 0층까지 이동하는데 필요한 버튼의 '최소' 개수
// +를 이용하려면 5를 초과하는 경우에 유리함
// 2556 -> 2 5 5 6 = 18 / 올려서 3000으로 가서 다시 내려가는 경우 3 4 4 4 = 15
// 결론은 6을 초과하는 경우 값을 올려쳐서 계산한다.
// 그럼 어떻게 계산 하느냐 뒤에서 부터 계산한다.
class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int left = storey % 10; // 나머지
            storey /= 10; // 몫
            
            if (left == 5) {
                if (storey % 10 >= 5) {
                    answer += 10 - left;
                    storey++;
                }
                else {
                    answer += left;
                }
            }
            else if (left > 5) {
                answer += 10 - left;
                storey++;
            }
            else {
                answer += left;
            }
            
        }
        
        return answer;
    }
}