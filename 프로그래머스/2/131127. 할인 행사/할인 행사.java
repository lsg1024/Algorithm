import java.util.*;

class Solution {
    
    static HashMap<String, Integer> discount_menu = new HashMap<>();
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        // 첫번째 할인 날
        for (int day = 0; day < 10; day++) {
            discount_menu.put(discount[day], discount_menu.getOrDefault(discount[day], 0) + 1);
        }
        
        // 회원 가입이 필요 여부
        if (create_membership(want, number)) answer++;
        
        // 반복 횟수 discount 개수가 10을 초과
        int cnt = discount.length - 10;
        
        if (cnt != 0) {
            for (int start = 1; start <= cnt; start++) {
                today_sale(discount, start, start + 9);
                if (create_membership(want, number)) answer++;
            } 
        }
       
        
        return answer;
    }
    
    //할인 제품 세팅
    static void today_sale(String[] discount, int start, int end) {

        // 하루 전 제품 제외
        discount_menu.put(discount[start - 1], discount_menu.get(discount[start - 1]) - 1);
        
        // 오늘 할인 제품 추가
        discount_menu.put(discount[end], discount_menu.getOrDefault(discount[end], 0) + 1);
        
    }
    
    // 10일 내에 제품들이 만족하면 회원가입
    static boolean create_membership(String[] want, int[] number) {
        for (int i = 0; i < number.length; i++) {    

            // 키 값이 존재한다면
            if (discount_menu.get(want[i]) != null && number[i] <= discount_menu.get(want[i])) {
                continue;
            }
            else {
                return false;
            }
            
        }
        
        return true;
    }
    
}