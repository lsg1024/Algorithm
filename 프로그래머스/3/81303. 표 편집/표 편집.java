import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        
        int size = n;
        int position = k;
        
        Stack<Integer> deleted = new Stack<>();
    
        String type;
        int move = 0;
        for (String c : cmd) {
            String[] orders = c.split(" ");
            type = orders[0];

            if (type.equals("D")) {
                position += Integer.parseInt(orders[1]);   
            } else if (type.equals("U")) {
                position -= Integer.parseInt(orders[1]);   
            } else if (type.equals("C")) {
                deleted.push(position);
                size--;
                if (size == position) {
                    position--;
                }
            } else if (type.equals("Z")) {
                if (deleted.pop() <= position) position++;
                size++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append("O");
        }
        while (!deleted.isEmpty()) {
            sb.insert(deleted.pop().intValue(), "X");
        }

        return sb.toString();
    }
}