import java.util.*;
import java.lang.*;
import java.io.*;


class Main {

    static Integer[] cranes, boxs;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        cranes = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cranes[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());

        boxs = new Integer[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boxs[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cranes, Collections.reverseOrder());
        Arrays.sort(boxs, Collections.reverseOrder());

        if (boxs[0] > cranes[0]) {
            System.out.println(-1);
            return;
        }

        int count = 0;
        List<Integer> boxList = new ArrayList<>(Arrays.asList(boxs));
        while (!boxList.isEmpty()) {
            int boxIndex = 0, craneIndex = 0;
            while (craneIndex < cranes.length) {
                if (boxIndex >= boxList.size()) {
                    break;
                } 
                if (cranes[craneIndex] >= boxList.get(boxIndex)) {
                    craneIndex++;
                    boxList.remove(boxIndex);
                } else {
                    boxIndex++;
                }
            }
            count++;
        }

        System.out.println(count);
    }
}