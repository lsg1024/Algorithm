import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int v, e, r;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static int[] visit;

    public static void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 1;

        queue.offer(num);
        visit[num] = count++;

        while(!queue.isEmpty()) {
            int a = queue.poll();

            for (int i = 0; i < graph.get(a).size(); i++) {
                int next_num = graph.get(a).get(i);

                if (visit[next_num] != 0) {
                    continue;
                }
                queue.offer(next_num);
                visit[next_num] = count++;
            }
        }

        for (int i = 1; i <= v; i++) {
            System.out.println(visit[i]);
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        visit = new int[v + 1];

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(bf.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i <= v; i++) {
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

        bfs(r);

    }
}
