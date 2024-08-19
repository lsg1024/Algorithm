import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0 && pq.isEmpty()) {
                sb.append(0).append("\n");
            }

            if (num == 0 && !pq.isEmpty()) {
                sb.append(pq.poll()).append("\n");
            }
            
            if (num != 0) {
                pq.add(num);
            }
            
        }
        System.out.println(sb);
    }
}