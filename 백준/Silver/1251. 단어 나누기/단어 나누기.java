import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String original = br.readLine();
        int length = original.length();

        String minString = "~"; 


        for (int i = 1; i <= length - 2; i++) { 
            for (int j = i + 1; j <= length - 1; j++) { 

                String part1 = original.substring(0, i);
                String part2 = original.substring(i, j);
                String part3 = original.substring(j, length);

                String rev1 = new StringBuilder(part1).reverse().toString();
                String rev2 = new StringBuilder(part2).reverse().toString();
                String rev3 = new StringBuilder(part3).reverse().toString();

                String combined = rev1 + rev2 + rev3;
                
                if (combined.compareTo(minString) < 0) {
                    minString = combined;
                }
            }
        }

        System.out.println(minString);
    }
}
