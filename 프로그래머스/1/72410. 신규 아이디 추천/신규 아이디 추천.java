import java.util.*;

class Solution {
    public String solution(String new_id) {
        
        new_id = func1(new_id);
        
        new_id = func2(new_id);
        
        new_id = func3(new_id);
        
        new_id = func4(new_id);
        
        new_id = func5(new_id);  
        
        new_id = func6(new_id);
        
        new_id = func7(new_id);
        
        return new_id;
    }
    
    static String func1(String new_id) {
         return new_id.toLowerCase();
    }
    
    static String func2(String new_id) {
        return new_id.replaceAll("[^a-z0-9\\-_.]", "");
    }
    
    static String func3(String new_id) {
        return new_id.replaceAll("\\.+", ".");
    }
    
    static String func4(String new_id) {
        while (new_id.startsWith(".")) {
            new_id = new_id.substring(1, new_id.length());
        }
        
        while (new_id.endsWith(".")) {
            new_id =  new_id.substring(0, new_id.length() - 1);
        }
        
        return new_id;
    }
    
    static String func5(String new_id) {
        if (new_id.equals("")) {
            new_id = "a";
        }
        return new_id;
    }
    
    static String func6(String new_id) {
        if (new_id.length() > 15) {
            new_id = new_id.substring(0, 15);
            
            while (new_id.endsWith(".")) {
                new_id =  new_id.substring(0, new_id.length() - 1);
            }
        }
        
        return new_id;
    }
    
    static String func7(String new_id) {
        if (new_id.length() <= 2) {
            String last = new_id.substring(new_id.length() - 1);
            
            while(new_id.length() != 3) {
                new_id += last;
            }
        }
        
        return new_id;
    }
    
}