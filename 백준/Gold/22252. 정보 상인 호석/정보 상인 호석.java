import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static HashMap<String, PriorityQueue<Integer>> gorillas = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long totalCost = 0;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                String name = st.nextToken();
                int amount = Integer.parseInt(st.nextToken());

                for (int j = 0; j < amount; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    gorillas.putIfAbsent(name, new PriorityQueue<>((o1, o2) -> {
                        return o2 - o1;
                    }));
                    gorillas.get(name).add(value);
                }
            } else if (type == 2) {
                String name = st.nextToken();
                int buyAmount = Integer.parseInt(st.nextToken());

                if (gorillas.containsKey(name) && !gorillas.get(name).isEmpty()) {
                    PriorityQueue<Integer> pq = gorillas.get(name);
                    for (int j = 0; j < buyAmount; j++) {
                        if (!pq.isEmpty()) {
                            totalCost += pq.poll();
                        } else {
                            break; 
                        }
                    }
   
                }
            }
        }

        System.out.println(totalCost);
    }
}