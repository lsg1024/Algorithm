import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>(); 
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            switch (command) {
                case 1:
                    int num = Integer.parseInt(st.nextToken());
                    stack.push(num);
                    break;
                case 2:
                    if (stack.size() != 0) {
                        sb.append(stack.pop()).append("\n");
                    }
                    else {
                        sb.append(-1).append("\n");
                    }
                    break;
                case 3:
                    sb.append(stack.size()).append("\n");
                    break;
                case 4:
                    if (stack.isEmpty()) {
                        sb.append(1).append("\n");
                    }
                    else {
                        sb.append(0).append("\n");
                    }
                    break;
                case 5:
                    if (stack.isEmpty()) {
                        sb.append(-1).append("\n");
                    }
                    else {
                        sb.append(stack.peek()).append("\n");
                    }
                    break;
                default:
                    break;
            }
        }

        br.close();

        System.out.println(sb);
        
    }
}