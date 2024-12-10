import java.util.*;

class Solution {
    
    //enroll center를 제외한 총 명단 || referral 추천인 || seller 판매원 || amount 판매 개수
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        int[] answer = new int[n];
        
        HashMap<String, String> parent = new HashMap<>();
        HashMap<String, Integer> sellerAmount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            parent.put(enroll[i], referral[i]);
            sellerAmount.put(enroll[i], 0);
        }

        for (int i = 0; i < seller.length; i++) {
            String currentSeller = seller[i];
            int price = amount[i] * 100;
            
            while (!currentSeller.equals("-")) {
                int payParent = price / 10;
                int keep = price - payParent;
                
                sellerAmount.put(currentSeller, sellerAmount.get(currentSeller) + keep);
                
                currentSeller = parent.get(currentSeller);
                price = payParent;
                
                if (price < 1) break;
            } 
        }
        
        for (int i = 0; i < n; i++) {
            answer[i] = sellerAmount.get(enroll[i]);
        }
        
        return answer;
    }
}