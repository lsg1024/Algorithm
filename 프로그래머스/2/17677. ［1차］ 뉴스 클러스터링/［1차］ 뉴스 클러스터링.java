import java.util.*;
import java.util.regex.*;

class Solution {
    public int solution(String str1, String str2) {
        
        ArrayList<String> arr1 = makeMultiset(str1);
        ArrayList<String> arr2 = makeMultiset(str2);

        int intersection = 0;
        Map<String, Integer> map1 = new HashMap<>();
        for (String s : arr1) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }

        for (String s : arr2) {
            if (map1.getOrDefault(s, 0) > 0) {
                intersection++;
                map1.put(s, map1.get(s) - 1);
            }
        }

        int union = arr1.size() + arr2.size() - intersection;

        double jaccard = union == 0 ? 1.0 : (double) intersection / union;

        return (int) (jaccard * 65536);
    }

    private ArrayList<String> makeMultiset(String str) {
        ArrayList<String> multiset = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            String s = str.substring(i, i + 2).toLowerCase();
            if (isCheck(s)) {
                multiset.add(s);
            }
        }
        return multiset;
    }

    private boolean isCheck(String s) {
        return Pattern.matches("^[a-zA-Z]{2}$", s);
    }
}
