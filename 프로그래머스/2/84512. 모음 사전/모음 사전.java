import java.util.*;

class Solution {
    
    // static int[] alphabat = {1, 4, 8, 14, 20};
    static String[] alphabat = {"A", "E", "I", "O", "U"};
    static ArrayList<String> arr = new ArrayList<>();
    
    static void dfs(String words) {
        
        arr.add(words);
        
        if (words.length() ==  5) {
            return;
        }
        
        for (int i = 0; i < 5; i++) {
            dfs(words + alphabat[i]);
        }
        
        
    }
    
    public int solution(String word) {
        int answer = 0;
        
        dfs("");
        
        int size = arr.size();
        
        for (int i = 0; i < size; i++) {
            if (arr.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}