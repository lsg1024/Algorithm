import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static Stack<String> stack;
    static Stack<String> stack2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        stack = new Stack<>();
        stack2 = new Stack<>();
        
        String word = br.readLine();

        for (int i = 0; i < word.length(); i++) {
            stack.push(Character.toString(word.charAt(i)));
        }

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int size = st.countTokens();

            if (size > 1) {
                String commend = st.nextToken();
                String w = st.nextToken();
                stack.push(w);
            } else {
                String commend = st.nextToken();
                if (commend.equals("L")) {
                    if (!stack.isEmpty()) {
                        String w = stack.pop();   
                        stack2.push(w);
                    }
                } else if (commend.equals("D")) {
                    if (!stack2.isEmpty()) {
                        String w = stack2.pop();
                        stack.push(w);   
                    }
                } else {
                    if (!stack.isEmpty()) {
                        stack.pop();   
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        sb.reverse();

        while (!stack2.isEmpty()) {
            sb.append(stack2.pop());
        }

        System.out.println(sb);
    }
}