class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        
        int m_size = m.length();
        
        m = changeMelody(m);
        
        int long_play_time = -1;
        for (String musicinfo : musicinfos) {
            String[] music = musicinfo.split(",");
            
            String[] music_start = music[0].split(":");
            int start_time = Integer.parseInt(music_start[0]) * 60 + Integer.parseInt(music_start[1]);
            
            String[] music_end = music[1].split(":");
            int end_time = Integer.parseInt(music_end[0]) * 60 + Integer.parseInt(music_end[1]);
            
            int play_time = end_time - start_time;

            String music_title = music[2];
            String music_melody = changeMelody(music[3]);
            
            int melody_time = music_melody.length();
            
            if (play_time > melody_time) {
                StringBuilder new_melody = new StringBuilder();
                
                for (int i = 0; i < play_time / melody_time; i++) {
                    new_melody.append(music_melody);
                }
                
                int left_melody = play_time % melody_time;
                new_melody.append(music_melody.substring(0, left_melody));
                music_melody = new_melody.toString();
            } else {
                music_melody = music_melody.substring(0, play_time);
            }
            
            if (music_melody.contains(m) && long_play_time < play_time) {
                long_play_time = play_time;
                answer = music_title;
            }
            
        }
        
        return long_play_time != -1 ? answer : "(None)";
    }
    
    static String changeMelody(String melody) {
        melody = melody.replaceAll("C#", "c");
        melody = melody.replaceAll("B#", "b");
        melody = melody.replaceAll("D#", "d");
        melody = melody.replaceAll("F#", "f");
        melody = melody.replaceAll("G#", "g");
        melody = melody.replaceAll("A#", "a");
        
        return melody;
    } 
    
}