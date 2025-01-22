import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> hashMap = new HashMap<>();

        List<Integer> numbers = new ArrayList<>();
        List<Integer> original = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
            hashMap.put(numbers.get(i), hashMap.getOrDefault(numbers.get(i), 0) + 1);
            original.add(numbers.get(i));
        }

        Collections.sort(numbers, (o1, o2) -> {
            if (hashMap.get(o1) == hashMap.get(o2)) {
                return original.indexOf(o1) - original.indexOf(o2);
            } else {
                return Integer.compare(hashMap.get(o2), hashMap.get(o1));
            }
        });

        for (int i = 0; i < N; i++) {
            System.out.print(numbers.get(i) + " ");
        }
    }
}