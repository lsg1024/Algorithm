import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         List<Integer> numbers = new ArrayList<>();
        int[] count = new int[8001];

        int N = Integer.parseInt(br.readLine());

        int total = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            numbers.add(number);
            total += number;
            count[number + 4000]++;

            if (number < min) min = number;
            if (number > max) max = number;
        }
        
        numbers.sort(Comparator.reverseOrder());

        System.out.println(Math.round((double) total / N));
        System.out.println(numbers.get(N/2));
        
        int maxCount = 0;
        for (int c : count) {
            if (c > maxCount) maxCount = c;
        }

        List<Integer> countList = new ArrayList<>();
        for (int i = 0; i < 8001; i++) {
            if (count[i] == maxCount) {
                countList.add(i - 4000);
            }
        }

        if (countList.size() == 1) {
            System.out.println(countList.get(0));
        } else {
            System.out.println(countList.get(1));
        }
        
        System.out.println(numbers.get(0) - numbers.get(N - 1));
    }
}