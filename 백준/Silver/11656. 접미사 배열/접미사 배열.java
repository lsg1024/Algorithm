import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        String[] names = new String[word.length()];
        for (int i = 0; i < word.length(); i++) {
            names[i] = word.substring(i);
        }

        Arrays.sort(names);

        StringBuilder sb = new StringBuilder();
        for (String name : names) {
            sb.append(name).append("\n");
        }
        System.out.println(sb);
    }
}