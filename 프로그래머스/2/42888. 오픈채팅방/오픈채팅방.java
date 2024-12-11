import java.util.*;

class Solution {
    static class Command {
        String id;
        String command;
        
        Command(String id, String command) {
            this.id = id;
            this.command = command;
        }
    }
    
    static Queue<Command> q = new ArrayDeque<>();
    static Map<String, String> nickName = new HashMap<>();
    
    public List<String> solution(String[] record) {
        for(String r : record) {
            String[] sp = r.split(" ");
            
            if(sp[0].equals("Enter")) {
                String uid = sp[1];
                String command = "님이 들어왔습니다.";
                q.add(new Command(uid, command));
                nickName.put(uid, sp[2]);
            } else if(sp[0].equals("Leave")) {
                String uid = sp[1];
                String command = "님이 나갔습니다.";
                q.add(new Command(uid, command));
            } else { //change
                String uid = sp[1];
                nickName.put(uid, sp[2]);
            }
        }
        
        List<String> answer = new ArrayList<>();
        for(Command c : q) {
            answer.add(nickName.get(c.id) + c.command);
        }
        
        
        return answer;
    }
}