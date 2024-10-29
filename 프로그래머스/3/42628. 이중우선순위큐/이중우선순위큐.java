import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer;
        
        ArrayList<Integer> numberList = new ArrayList<>();
        
        for (String operation : operations) {
            String[] current = operation.split(" ");
            
            if (current[0].equals("I")) {
                
                numberList.add(Integer.parseInt(current[1]));
                Collections.sort(numberList);
                
            } else {
                
                if (current[1].equals("1")) {
                    
                    if (!numberList.isEmpty()) {
                        numberList.remove(numberList.size() - 1);
                    }
                    
                } else {
                    
                    if (!numberList.isEmpty()) {
                        numberList.remove(0);
                    }
                    
                }
            }
        }
        
        if (!numberList.isEmpty()) {
            return answer = new int[] {numberList.get(numberList.size() - 1), numberList.get(0)};
        }
        
        return answer = new int[] {0, 0};
    }
}