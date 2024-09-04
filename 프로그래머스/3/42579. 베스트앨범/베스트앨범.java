import java.util.*;

class Solution {
    
    static class Genre implements Comparable<Genre> {
        String name;
        int total;
        int idx;
        
        Genre(String name, int total, int idx) {
            this.name = name;
            this.total = total;
            this.idx = idx;
        }
        
        @Override
        public int compareTo(Genre o) {
            return o.total - this.total;
        }
    }
    
    
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList();
        Map<String, Integer> sType = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            if(sType.containsKey(genres[i])) {
                sType.put(genres[i] , sType.get(genres[i]) + plays[i]);
            } else {
                sType.put(genres[i], plays[i]);
            }
        }
        
        //장르 분류 리스트
        List<Genre> gList = new ArrayList();
        for(Map.Entry<String, Integer> e: sType.entrySet())
            gList.add(new Genre(e.getKey(), e.getValue(),-1));
        Collections.sort(gList);
        
        
        
        for(Genre g: gList) {
            
            PriorityQueue<Genre> song = new PriorityQueue();
            for(int i = 0 ; i < genres.length; i++) {
                
                if(g.name.equals(genres[i])) {
                    song.add(new Genre(genres[i], plays[i], i));
                }
            }
            
            int songSize = song.size();
            for(int i = 0 ; i < Math.min(songSize , 2); i++) {
                answer.add(song.poll().idx);
            }
        }
        
        
        return answer;
    }
}