import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public void sol_9935() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		String bomb = br.readLine();
		int bombLen = bomb.length();
		
		Stack<Character> s = new Stack<>();
		
		for (int i = 0; i < str.length(); i++) {
			s.push(str.charAt(i));
			if (s.size() >= bombLen) {
				// bomb문자열의 길이보다 작지 않으면 검사
				boolean check = true;
				for (int j = 0; j < bombLen; j++) {
					if (s.get(s.size() - bombLen + j) != bomb.charAt(j)) {
						check = false;
						break;
					}
				}
				// 폭발 문자열이 있으면 pop
				if (check) {
					for (int j = 0; j < bombLen; j++) {
						s.pop();
					}
				}
			}
		}
		
		if (s.size() == 0) {
			sb.append("FRULA");
		}
		else {
			for (int i = 0; i < s.size(); i++) {
				sb.append(s.get(i));
			}
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_9935();
	}
}
