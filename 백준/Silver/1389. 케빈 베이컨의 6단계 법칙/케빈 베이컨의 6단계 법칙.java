import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, M, min_count, index;
    static int[] distances;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        
        min_count = Integer.MAX_VALUE;
        index = 0;
        for (int i = 1; i < N + 1; i++) {
            int count = bfs(i);
            if (min_count > count) {
                index = i;
                min_count = count;
            }
        }

        System.out.println(index);
    }

    static int bfs(int node) {

        int[] distances = new int[N + 1];
        Arrays.fill(distances, -1);
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(node);
        distances[node] = 0;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            for (int nextNode : graph.get(currentNode)) {
                if (distances[nextNode] == -1) {
                    distances[nextNode] = distances[currentNode] + 1;
                    queue.offer(nextNode);
                }
            }
        }

        int count = 0;
        for (int i = 1; i < N + 1; i++) {
            if (i != node) {
                 count += distances[i];   
            }
        }

        return count;
        
    }
    
}