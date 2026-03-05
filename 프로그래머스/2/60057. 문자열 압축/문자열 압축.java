class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for (int sc = 1; sc <= s.length() / 2; sc++) {
            
            StringBuilder f_word = new StringBuilder();
            
            int count = 1;
            String word = s.substring(0, sc);
            
            for (int i = sc; i < s.length(); i+=sc) {
                
                int end = Math.min(i + sc, s.length());
                String word2 = s.substring(i, end);
                
                if (word.equals(word2)) {
                    count++;
                } else {
                    
                    if (count == 1) {
                        f_word.append(word);
                    } else {
                        f_word.append(count).append(word);
                    }
                    
                    count = 1;
                    word = word2;
                    
                }
            }
            
            if (count == 1) {
                f_word.append(word);
            } else {
                f_word.append(count).append(word);
            }
            
            answer = Math.min(answer, f_word.length());
        }
        
        return answer;
    }
}