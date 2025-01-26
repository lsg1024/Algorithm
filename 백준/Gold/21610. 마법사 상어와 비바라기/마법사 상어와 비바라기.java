import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, M;
    static boolean[][] visited;
    static List<int[]> clouds;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1}; 
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] cx = {-1, -1, 1, 1};
    static int[] cy = {-1, 1, -1, 1};
    static int[][] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        graph = new int[N][N];
        clouds = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clouds.add(new int[]{N - 1, 0});
        clouds.add(new int[]{N - 1, 1});
        clouds.add(new int[]{N - 2, 0});
        clouds.add(new int[]{N - 2, 1});
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int direction = Integer.parseInt(st.nextToken()) - 1;
            int distance = Integer.parseInt(st.nextToken());

            moveClouds(direction, distance);
            rain();
            waterCopy();
            generateClouds();
        }

        System.out.println(calculateWater());
    
    }

    static void moveClouds(int direction, int distance) {
        visited = new boolean[N][N];
        for (int[] cloud : clouds) {
            cloud[0] = (cloud[0] + dx[direction] * distance % N + N) % N;
            cloud[1] = (cloud[1] + dy[direction] * distance % N + N) % N;
            visited[cloud[0]][cloud[1]] = true;
        }
    }

    static void rain() {
        for (int[] cloud : clouds) {
            graph[cloud[0]][cloud[1]]++;
        }
    }

    static void waterCopy() {
        for (int[] cloud : clouds) {
            int x = cloud[0];
            int y = cloud[1];
            int water = 0;

            for (int i = 0; i < 4; i++) {
                int nx = x + cx[i];
                int ny = y + cy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < N && graph[nx][ny] > 0) {
                    water++;
                }
            }

            graph[x][y] += water;
        }
    }

    static void generateClouds() {
        List<int[]> newClouds = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && graph[i][j] >= 2) {
                    newClouds.add(new int[] {i, j});
                    graph[i][j] -= 2;
                }
            }
        }
        clouds = newClouds;
    }

    static int calculateWater() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += graph[i][j];
            }
        }

        return sum;
    }

}