import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int L, C, sizeA, sizeB;
    static String[] words;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        words = new String[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            words[i] = st.nextToken();
        }

        Arrays.sort(words);

        visited = new boolean[C];
        func(0, 0);

        System.out.println(sb);
        
    }

    static void func(int s, int depth) {

        if (depth == L) {
            String word = "";

            int a = 0;
            int b = 0;

            for (int i = 0; i < C; i++) {
                if (visited[i]) {
                    String w = words[i];
                    word += w;

                    if (w.equals("a") || w.equals("e") || w.equals("i") || w.equals("o") || w.equals("u") ) {
                        a++;
                    } else {
                        b++;
                    }
                }
            }

            if (a >= 1 && b >= 2) {
                sb.append(word).append("\n");
            }
        }
        
        for (int i = s; i < C; i++) {
            visited[i] = true;
            func(i + 1, depth + 1);
            visited[i] = false;
        }
        
    }
}