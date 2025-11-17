import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<Integer> queue = new LinkedList<>();

        int T = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            String build = st.nextToken();

            
            if ("push_front".equals(build)) {
                queue.addFirst(Integer.parseInt(st.nextToken()));
            } else if ("push_back".equals(build)) {
                queue.addLast(Integer.parseInt(st.nextToken()));
            } else if ("pop_front".equals(build)) {
                if (queue.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                     sb.append(queue.pollFirst()).append("\n");   
                }
            } else if ("pop_back".equals(build)) {
                if (queue.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(queue.pollLast()).append("\n");   
                }
            } else if ("size".equals(build)) {
                sb.append(queue.size()).append("\n");
            } else if ("empty".equals(build)) {
                if (queue.isEmpty()) {
                    sb.append("1").append("\n");    
                } else {
                     sb.append("0").append("\n");
                }
            } else if ("front".equals(build)) {
                if (queue.isEmpty()) {
                    sb.append("-1").append("\n");    
                } else {
                     sb.append(queue.getFirst()).append("\n");   
                }
            } else {
                if (queue.isEmpty()) {
                    sb.append("-1").append("\n");    
                } else {
                     sb.append(queue.getLast()).append("\n");   
                }
            }
        }

        System.out.print(sb.toString());
    }
}