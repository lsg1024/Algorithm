import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // Pair 클래스를 사용하여 나이와 이름을 저장
        Pair[] members = new Pair[n];

        for (int i = 0; i < n; i++) {
            int age = sc.nextInt();
            String name = sc.next();
            members[i] = new Pair(age, name, i);
        }

        // 비교 정렬
        Arrays.sort(members, (p1, p2) -> {
            if (p1.age == p2.age) {
                return Integer.compare(p1.index, p2.index);
            } else {
                return Integer.compare(p1.age, p2.age);
            }
        });

        // 정렬된 결과 출력
        for (int i = 0; i < n; i++) {
            System.out.println(members[i].age + " " + members[i].name);
        }


    }

    static class Pair {
        int age;
        String name;
        int index;

        public Pair(int age, String name, int index) {
            this.age = age;
            this.name = name;
            this.index = index;
        }
    }
}