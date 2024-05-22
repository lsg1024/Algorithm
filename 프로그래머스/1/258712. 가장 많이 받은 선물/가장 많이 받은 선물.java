import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        int answer = 0;

        HashMap<String, ArrayList<Integer>> hashmap = new HashMap<>();
        HashMap<String, Integer> totalGift = new HashMap<>();

        int[] next_gift = new int[friends.length];
        int[] gift_point = new int[friends.length];

        for (int i = 0; i < friends.length; i++) {
            ArrayList<Integer> list = new ArrayList<>(Collections.nCopies(friends.length, 0));
            hashmap.put(friends[i], list);
            totalGift.put(friends[i], 0);
        }

        for (String gift : gifts) {
            String[] giftList = gift.split(" ");
            String giver = giftList[0];
            String receiver = giftList[1];

            ArrayList<Integer> givelist = hashmap.get(giver);
            int getname = Arrays.asList(friends).indexOf(receiver);

            if (givelist != null) {
                givelist.set(getname, givelist.get(getname) + 1);
            }
        }

        for (int i = 0; i < friends.length; i++) {
            ArrayList<Integer> list = hashmap.get(friends[i]);
            int sumGiven = 0;
            int sumReceived = 0;
            for (int j = 0; j < friends.length; j++) {
                if (i != j) {
                    sumGiven += list.get(j);
                    sumReceived += hashmap.get(friends[j]).get(i);
                }
            }
            gift_point[i] = sumGiven - sumReceived;
        }

        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                if (i != j) {
                    int given1To2 = hashmap.get(friends[i]).get(j);
                    int given2To1 = hashmap.get(friends[j]).get(i);

                    if (given1To2 > given2To1) {
                        next_gift[i]++;
                    } else if (given1To2 == given2To1 && gift_point[i] > gift_point[j]) {
                        next_gift[i]++;
                    }
                    
                }
            }
        }

        for (int v : next_gift) {
            if (v > answer) {
                answer = v;
            }
        }

        return answer;
    }
}