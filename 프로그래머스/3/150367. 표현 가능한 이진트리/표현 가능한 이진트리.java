public class Solution {
    
	private static int[] answer;
    
    public int[] solution(long[] numbers) {
        answer = new int [numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
        	String cur = Long.toBinaryString(numbers[i]); //이진값으로 변경
        	int j = 0;
            
        	while((int)Math.pow(2, j)-1 < cur.length()) { //해당 길이가 2의 몇승인지 체크
        		j++;
        	}
            
        	while((int)Math.pow(2, j)-1 != cur.length()) { //완전포화트리 개수만큼 0추가해서 맞추기
        		cur = "0"+ cur;
        	}
            
        	if(dfs(cur)) { 
        		answer[i] = 1;
        	}
        }
        return answer;
    }
    
    private static boolean dfs(String number) {
		boolean valid = true;
		
        //가운데를 기준으로 왼쪽 오른쪽 확인
		int mid = (number.length()-1)/2;
		char root = number.charAt(mid);
		String left = number.substring(0,mid);
		String right = number.substring(mid+1,number.length()); 
		
		if(root == '0' && (left.charAt((left.length()-1)/2)=='1' || right.charAt((right.length()-1)/2)=='1')){ //왼쪽 오른쪽 하나라도 1인데 부모가 0이면 실패!
			return false;
		}
		
		if(left.length() >= 3) { //왼쪽 오른쪽 다시 체크
			valid = dfs(left);
			if(valid) {
				valid = dfs(right);
			}
		}
		return valid;
	}
}