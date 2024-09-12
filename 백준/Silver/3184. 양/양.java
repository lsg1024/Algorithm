import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int R, C, sheeps, wolfs, sheep, wolf;
    static String[][] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new String[R][C];

        for (int row = 0; row < R; row++) {
            String input = br.readLine();
            for (int col = 0; col < C; col++) {
                graph[row][col] = Character.toString(input.charAt(col));
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!graph[i][j].equals("#")) {
                    sheep = 0;
                    wolf = 0;
                    dfs(i, j);
                    if (sheep > wolf) {
                        sheeps += sheep;
                    }
                    else {
                        wolfs += wolf;
                    }
                }

                
            }
        }
        System.out.println(sheeps + " " + wolfs);
    }

    static void dfs(int x, int y) {
        
        if (0 <= x && x < R && 0 <= y && y < C && !graph[x][y].equals("#")) {
            if (graph[x][y].equals("o")) {
                sheep++;
            }
            if (graph[x][y].equals("v")) {
                wolf++;
            }
            graph[x][y] = "#";
            dfs(x + 1, y);
            dfs(x - 1, y);
            dfs(x, y + 1);
            dfs(x, y - 1);
            return;
        }
            
    }
}