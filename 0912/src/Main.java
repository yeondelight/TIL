import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Stack;

public class Main {
	
	public void sol_12904() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		String T = br.readLine();
		
		Stack<Character> td = new Stack<>();
		
		for (int i = 0; i < T.length(); i++) {
			td.push(T.charAt(i));
		}
		
		while (S.length() != td.size()) {
			if (td.pop() == 'B') {
				Collections.reverse(td);
			}
		}
		
		for (int i = td.size() - 1; i >= 0; i--) {
			if (S.charAt(i) != td.pop()) {
				System.out.println(0);
				return;
			}
		}
		
		System.out.println(1);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_12904();
	}
}
