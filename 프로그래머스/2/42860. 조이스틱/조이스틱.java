class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        int minMove = length - 1; 
        
        for (int i = 0; i < length; i++) {
            int c = name.charAt(i) - 'A';
            answer += Math.min(c, 26 - c);
        }

        for (int i = 0; i < length; i++) {
            int next = i + 1;
        
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }

            minMove = Math.min(minMove, i * 2 + length - next);
            minMove = Math.min(minMove, i + 2 * (length  - next));
        }

        answer += minMove;
        return answer;
    }
}
