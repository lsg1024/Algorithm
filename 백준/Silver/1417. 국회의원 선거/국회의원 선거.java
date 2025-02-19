import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, one;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                one = Integer.parseInt(br.readLine());
            } else {
                pq.offer(Integer.parseInt(br.readLine()));   
            }
        }

        if (N == 1) {
            System.out.println(0);
            return;
        }

        int count = 0;
        while (true) {
            int next = pq.poll();

            if (one > next) {
                System.out.println(count);
                break;
            } else {
                next--;
                one++;
                count++;
                pq.offer(next);
            }
        }
        
    }
}