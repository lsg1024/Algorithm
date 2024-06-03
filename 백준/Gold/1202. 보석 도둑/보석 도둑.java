import java.io.*;
import java.util.*;

class Main {
    // n 보석 개수, k 가방 개수, c 가방 무게
    static int n, k;
    static int[][] jewelry;
    static int[] bags;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        jewelry = new int[n][2];
        bags = new int[k];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            jewelry[i][0] = Integer.parseInt(st.nextToken());
            jewelry[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewelry, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long totalPrice = 0;
        int index = 0;
        for (int i = 0; i < k; i++) {

            while (index < n && jewelry[index][0] <= bags[i]) {
                pq.add(jewelry[index][1]);
                index++;
            }

            if (!pq.isEmpty()) {
                totalPrice += pq.poll();
            }
            
        }

        System.out.println(totalPrice);
    }
}
