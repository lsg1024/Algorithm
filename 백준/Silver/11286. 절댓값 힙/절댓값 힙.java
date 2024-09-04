import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);

            if (absA != absB) {
                return absA - absB;
            }
            else {
                return a - b;
            }
            
        });
        
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num != 0) {
                pq.offer(num);
            }
            else {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                }
                else {
                    sb.append(pq.poll()).append("\n");
                }
            }
        }

        System.out.println(sb);
        
    }
}