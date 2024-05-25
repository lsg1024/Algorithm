import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        
        int last = 0; // 마지막으로 push된 숫자
        for (int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            
            if (command.equals("push")) {
                int number = Integer.parseInt(st.nextToken());
                queue.add(number);
                last = number;
            }
            else if (command.equals("pop")) {
                if (queue.peek() != null) {
                    sb.append(queue.poll()).append("\n");  
                }
                else {
                    sb.append("-1").append("\n");
                }
            }
            else if (command.equals("size")) {
                sb.append(queue.size()).append("\n");
            }
            else if (command.equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append("1").append("\n");  
                }
                else {
                    sb.append("0").append("\n");  
                }
            }
            else if (command.equals("front")){
                if (queue.peek() == null) {
                    sb.append("-1").append("\n");   
                } else {
                    sb.append(queue.peek()).append("\n");  
                } 
            }
            else if (command.equals("back")) {
                if (queue.isEmpty()) {
                    sb.append("-1").append("\n");  
                }
                else {
                    sb.append(last).append("\n");  
                }
            }
        }

        System.out.print(sb);
    }
}
