import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public void sol_10799() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String stick = br.readLine();
		
		int ans = 0;
		Stack<Character> s = new Stack<>();
		char prev = ' ';
		for (int i = 0; i < stick.length(); i++) {
			char curr = stick.charAt(i);
			if (curr == '(') {
				s.push(curr);
			} else {
				s.pop();
				if (prev == '(') {	// 막대를 잘라야함
					ans += s.size();
				} else {			// 막대가 끝남
					ans++;
				}
			}
			prev = curr;
		}
		
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_10799();
	}
}
