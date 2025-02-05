import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, minIndex;
    static int[] dx = new int[] {1, -1, 0, 0};
    static int[] dy = new int[] {0, 0, 1, -1};
    static int[][] tables;
    static Map<Integer, List<Integer>> perferences = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        tables = new int[N][N];

        List<Integer> orders = new ArrayList<>();
        
        for (int i = 1; i < N * N + 1; i++) {
            st = new StringTokenizer(br.readLine());

            int student = Integer.parseInt(st.nextToken());
            orders.add(student);
            perferences.put(student, new ArrayList<>());
            for (int j = 0; j < 4; j++) {
                perferences.get(student).add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int order : orders) {
            studentTable(order);
        }

        countLikes();
        
    }

    static void studentTable(int order) {

        int maxLikes = -1, maxEmpty = -1;
        int bestX = -1, bestY = -1;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (tables[x][y] != 0) continue;

                int likes = 0, empty = 0;

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                        if (tables[nx][ny] == 0) empty++;
                        else if (perferences.get(order).contains(tables[nx][ny])) likes++;
                    }
                }

                if (likes > maxLikes || (likes == maxLikes && empty > maxEmpty)
                   || (likes == maxLikes && empty == maxEmpty && (x < bestX || (x == bestX && y < bestY)))) {
                        maxLikes = likes;
                        maxEmpty = empty;
                        bestX = x;
                        bestY = y;
                   }
            }
        }

        tables[bestX][bestY] = order;
        
    }

    static void countLikes() {
        int total = 0;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                int student = tables[x][y];
                int like = 0;

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    
                    if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                        if (perferences.get(student).contains(tables[nx][ny])) like++;
                    }
                }

                if (like == 1) total += 1;
                else if (like == 2) total += 10;
                else if (like == 3) total += 100;
                else if (like == 4) total += 1000;
            }
        }

        System.out.println(total);
    }
}