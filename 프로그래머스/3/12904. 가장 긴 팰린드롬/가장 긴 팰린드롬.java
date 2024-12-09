class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        int size = s.length();
        
        if (size == 1) {
            return 1;
        }
        
        for (int i = 0; i < size - 1; i++) {
            answer = Math.max(answer, isPalind(s, i, i));
            answer = Math.max(answer, isPalind(s, i, i + 1));
        }

        return answer;
    }
    
    static int isPalind(String s, int left, int right) {
        
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        return right - left - 1;
    }
}