import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int[] parent, truth;
    static boolean[] knowperson;
    static List<List<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        if (p != 0) {
            truth = new int[p];
            for (int i = 0; i < p; i++) {
                truth[i] = Integer.parseInt(st.nextToken());
            }
        } else {
            System.out.println(M);
            return;
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            List<Integer> party = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                party.add(Integer.parseInt(st.nextToken()));
            }
            graph.add(party);
        }

        knowperson = new boolean[N + 1];
        parent = new int[N + 1];

        for (int person : truth) {
            knowperson[person] = true;
        }

        for (int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < graph.get(i).size() - 1; j++) {
                union(graph.get(i).get(j), graph.get(i).get(j + 1));
            }
        }

        for (int i = 1; i < N + 1; i++) {
            if (knowperson[i]) {
                int parent = find(i);
                knowperson[find(i)] = true;
            }
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            boolean known = true;
            for (int j = 0; j < graph.get(i).size(); j++) {
                int num = graph.get(i).get(j);
                int parent = find(num);

                if (knowperson[parent]) {
                    known = false;
                    break;
                }
            }

            if (known) count++;
        }

        System.out.println(count);
        
    }

    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }
}