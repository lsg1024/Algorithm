

class Solution {
    public int[] solution(String s) {
        
        int total_count = 0;
        int total_removeCount = 0;
        
        while (!s.equals("1")) {

            int s_bf = s.length();
            s = s.replaceAll("0", "");
            int s_af = s.length();
            total_removeCount += (s_bf - s_af);
            
            s = Integer.toBinaryString(s.length());
            
            
            total_count++;
        }
        
        return new int[] {total_count, total_removeCount};
    }
    
    
}