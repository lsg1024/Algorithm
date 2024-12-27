import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        
        int table_size = n;
        Stack<Integer> deleted = new Stack<>();

        for (String c : cmd) {
            String[] orders = c.split(" ");
            String type = orders[0];

            if (type.equals("D")) {
                k += Integer.parseInt(orders[1]);
            } else if (type.equals("U")) {
                k -= Integer.parseInt(orders[1]);
            } else if (type.equals("C")) {
                deleted.add(k);
                table_size--;
                if (k == table_size) k--;
            } else if (type.equals("Z")) {
                if (deleted.pop() <= k) k++;
                table_size++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < table_size; i++) {
            sb.append("O");
        }
        while(!deleted.isEmpty()) {
            sb.insert(deleted.pop().intValue(), "X");
        }
        
        return sb.toString();
    }
}
