import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue priorityqueue = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {

            int commend = Integer.parseInt(br.readLine());
            
            if (commend == 0) {
                if (priorityqueue.isEmpty()) {
                    sb.append(0).append("\n");
                }
                else {
                    sb.append(priorityqueue.poll()).append("\n");
                }
            }
            else {
                priorityqueue.add(commend);
            }
        }

        System.out.print(sb);
    }
}