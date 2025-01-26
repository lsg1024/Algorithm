import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String words = br.readLine();

        HashSet<String> setWords = new HashSet<>();
        for (int i = 0; i < words.length(); i++) {
            for (int j = i + 1; j <= words.length(); j++) {
                setWords.add(words.substring(i, j));
            }
        }

        System.out.println(setWords.size());
    }
}