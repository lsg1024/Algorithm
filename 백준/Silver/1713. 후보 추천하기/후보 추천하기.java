import java.util.*;
import java.io.*;

class Main {
    static int N, K;
    static LinkedHashMap<Integer, Integer> rank = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            checkRank(Integer.parseInt(st.nextToken()));
        }

        List<Integer> result = new ArrayList<>(rank.keySet());
        Collections.sort(result);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    static void checkRank(int number) {
        if (rank.containsKey(number)) {
            rank.put(number, rank.get(number) + 1);
            return;
        }

        if (rank.size() < N) {
            rank.put(number, 1);
            return;
        }

        int minKey = -1;
        int minValue = Integer.MAX_VALUE;
        
        for (Map.Entry<Integer, Integer> entry : rank.entrySet()) {
            if (entry.getValue() < minValue) {
                minValue = entry.getValue();
                minKey = entry.getKey();
            }
        }

        rank.remove(minKey);
        rank.put(number, 1);
    }
}
