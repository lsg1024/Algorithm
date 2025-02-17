import java.util.*;
import java.io.*;

class Main {

    static int A, B;

    static class Node {
        int num;
        String command;

        Node(int num, String command) {
            this.num = num;
            this.command = command;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            System.out.println(bfs());
        }
    }

    static String bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(A, ""));

        boolean[] visited = new boolean[10000]; // ✅ 0~9999까지만 사용 가능
        visited[A] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            int n = node.num;
            String command = node.command;

            if (n == B) {
                return command;
            }

            int[] nextNums = {D(n), S(n), L(n), R(n)};
            char[] commands = {'D', 'S', 'L', 'R'};

            for (int i = 0; i < 4; i++) {
                int newNum = nextNums[i];

                if (!visited[newNum]) {
                    visited[newNum] = true;
                    queue.offer(new Node(newNum, command + commands[i]));
                }
            }
        }
        return "";
    }

    static int D(int n) {
        return (n * 2) % 10000;
    }

    static int S(int n) {
        return (n == 0) ? 9999 : n - 1;
    }

    static int L(int n) {
        return (n % 1000) * 10 + (n / 1000);
    }

    static int R(int n) {
        return (n % 10) * 1000 + (n / 10); // ✅ 4자리 수 유지
    }
}
