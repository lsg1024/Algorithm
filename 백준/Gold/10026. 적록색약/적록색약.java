import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N;
    static String[][] graph, graphBlind;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new String[N][N];
        graphBlind = new String[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = Character.toString(input.charAt(j));
                graphBlind[i][j] = graph[i][j].equals("G") ? "R" : graph[i][j];
            }
        }

        int normalCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!graph[i][j].equals("C")) { 
                    dfs(i, j, graph[i][j], graph); 
                    normalCount++;
                }
            }
        }

        int colorBlindCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!graphBlind[i][j].equals("C")) { 
                    dfs(i, j, graphBlind[i][j], graphBlind);
                    colorBlindCount++;
                }
            }
        }

        System.out.println(normalCount + " " + colorBlindCount);
    }

    static void dfs(int x, int y, String target, String[][] graph) {

        if (0 <= x && x < N && 0 <= y && y < N) {
            if (graph[x][y].equals(target)) {
                graph[x][y] = "C";
                dfs(x + 1, y, target, graph);
                dfs(x - 1, y, target, graph);
                dfs(x, y + 1, target, graph);
                dfs(x, y - 1, target, graph);
                return;
            }

        }
        
    }
    
}