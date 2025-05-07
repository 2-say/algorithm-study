import java.util.*;

class Solution {
    static String[] userId;
    static String[] bannedId;
    static Set<Set<String>> result = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        userId = user_id;
        bannedId = banned_id;
        dfs(new HashSet<>(), 0);       
        return result.size();
    }
    
    public void dfs(Set<String> s, int depth) {
        if(bannedId.length == depth) {
            result.add(s);
            return;
        }
        
        for(int i = 0; i < userId.length; i++) {
            if(s.contains(userId[i])) {
                continue;
            }
            
            if(userId[i].length() == bannedId[depth].length() && isSame(userId[i], bannedId[depth])) {
                s.add(userId[i]);
                dfs(new HashSet<>(s), depth + 1);
                s.remove(userId[i]);
            }
        }
    }
    
    public boolean isSame(String u, String b) {
        char[] cu = u.toCharArray();
        char[] cb = b.toCharArray();
        
        for(int i = 0; i < Math.min(cu.length, cb.length); i++) {
            if(cb[i] == '*') continue;
            if(cu[i] != cb[i]) return false;
        }
        return true;
    }
}