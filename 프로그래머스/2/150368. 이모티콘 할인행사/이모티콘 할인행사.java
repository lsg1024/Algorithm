class Solution {

    static int maxSubscriber = 0; 
    static int maxSales = 0;
    static int[] discount  = new int[] {10, 20, 30, 40};
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};

        
        func(0, new int[emoticons.length], users, emoticons);
        
        return new int[] {maxSubscriber, maxSales};
    }
    
    static void func(int depth, int[] discountRates, int[][] users, int[] emoticons) {
        
        if (depth == emoticons.length) {
            discount_func(discountRates, emoticons, users);
            return;
        }
        
        
        for (int j = 0; j < 4; j++) {
            discountRates[depth] = discount[j];
            func(depth + 1, discountRates, users, emoticons);
        }
        
        
    }
    
    static void discount_func(int[] discountRates, int[] emoticons, int[][] users) {
        int sales = 0;
        int subscriber = 0;
        
        for (int[] user : users) {
            int userRate = user[0];
            int userMoney = user[1];
            int useMoney = 0;
            
            for (int i = 0; i < discountRates.length; i++) {
                if (userRate <= discountRates[i]) {
                    useMoney += emoticons[i] * (100 - discountRates[i]) / 100;
                }
            }
            
            if (useMoney >= userMoney) {
                subscriber += 1;
            } else {
                sales += useMoney;
            }
        }
        
        if (maxSubscriber < subscriber || (subscriber == maxSubscriber && sales > maxSales)) {
                maxSubscriber = subscriber;
                maxSales = sales;
        }
    }
    
}