class Solution {
    public int solution(int n) {
        int count = Integer.bitCount(n);
        int answer = n + 1;
        
        while (Integer.bitCount(answer) != count) {
            answer++;
        }
        
        return answer;
    }
}
