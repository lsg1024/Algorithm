import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new int[101];

        Arrays.fill(visited, Integer.MAX_VALUE);
        
        for (int i = 0; i < 101; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
        }

        // System.out.println(graph.get(12).get(j));

        bfs(1);

        System.out.println(visited[100]);
        
    }

    static void bfs(int start) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start, 0});
        visited[start] = 0;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int count = current[1];

            // 주사위 굴리기
            for (int i = 1; i <= 6; i++) {
                int nx = x + i;

                // 100을 넘는지 && 방문 했는지
                if (nx <= 100) {

                    if (graph.get(nx).isEmpty()) {
                        if (visited[nx] > count + 1) {
                            visited[nx] = count + 1;
                            queue.offer(new int[] {nx, count + 1});
                        }
                    }
                    else {
                        // 사다리 혹은 뱀
                        for (int warp = 0; warp < graph.get(nx).size(); warp++) {
                            int next = graph.get(nx).get(warp);
                            if (visited[next] > count + 1) {
                                visited[next] = count + 1;
                                queue.offer(new int[] {next, count + 1});
                             }
                        }
                    }
                }
            }
            
        }

    }
    
}