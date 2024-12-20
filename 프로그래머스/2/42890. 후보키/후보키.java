import java.util.*;

class Solution {
    
    static List<List<Integer>> combinationKeys = new ArrayList<>();
    static List<List<Integer>> combinations = new ArrayList<>();
    
    public int solution(String[][] relation) {
        int size = relation[0].length;
        
        for (int i = 1; i <= size; i++) {
            backtrack(new ArrayList<>(), 0, size, i);
        }
        
        for (List<Integer> combination : combinations) {
            if (isUnion(relation, combination) && isMinimum(combination)) {
                combinationKeys.add(combination);
            }
        }
        
        return combinationKeys.size();
    }
    
    static void backtrack(List<Integer> combi, int start, int end, int target) {
        if (combi.size() == target) {
            combinations.add(new ArrayList<>(combi));
            return;
        }
        
        for (int i = start; i < end; i++) {
            combi.add(i);
            backtrack(combi, i + 1, end, target);
            combi.remove(combi.size() - 1);
        }
    }
    
    static boolean isUnion(String[][] relation, List<Integer> combination) {
        Set<String> union = new HashSet<>();
        
        for (String[] row : relation) {
            StringBuilder sb = new StringBuilder();
            for (int col : combination) {
                sb.append(row[col]);
            }
            if (!union.add(sb.toString())) {
                return false;
            }
        }
        return true;
    }
    
    static boolean isMinimum(List<Integer> combination) {
    
        for (List<Integer> key : combinationKeys) {
            if (combination.containsAll(key)) {
                return false; 
            }
        }
        return true;
    }
}
