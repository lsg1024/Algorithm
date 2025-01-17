import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[][] classes = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            classes[i][0] = s;
            classes[i][1] = e;
        }

        Arrays.sort(classes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] classs : classes) {
            if (!pq.isEmpty() && pq.peek() <= classs[0]) {
                pq.poll();
            }
            pq.offer(classs[1]);
        }

        System.out.print(pq.size());
    }
}