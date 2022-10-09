import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public void sol_2504() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int ans = 0;
		int temp = 1;
		Stack<Character> s = new Stack<>();
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			switch(c) {
			case '(':
				s.push(c);
				temp *= 2;
				break;
			case '[':
				s.push(c);
				temp *= 3;
				break;
			case ')':
				if (s.isEmpty() || s.peek() != '(') {	// invalid
					System.out.println(0);
					return;
				}
				if (str.charAt(i-1) == '(') {
					ans += temp;
				}
				temp /= 2;
				s.pop();
				break;
			case ']':
				if (s.isEmpty() || s.peek() != '[') {	// invalid
					System.out.println(0);
					return;
				}
				if (str.charAt(i-1) == '[') {
					ans += temp;
				}
				temp /= 3;
				s.pop();
				break;
			}
		}
		
		if (s.isEmpty())	System.out.println(ans);
		else				System.out.println(0);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2504();
	}
}
