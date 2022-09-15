import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public void sol_16120() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Character[] ppap = {'P', 'P', 'A', 'P'};
		
		Stack<Character> s = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			s.push(str.charAt(i));
			if (s.size() >= 4) {	// PPAP인지 확인
				boolean check = true;
				for (int j = 0; j < 4; j++) {
					if (s.get(s.size() - 4 + j) != ppap[j]) {
						check = false;
					}
				}
				if (check) {
					for (int j = 0; j < 4; j++) {
						s.pop();
					}
					s.push('P');
				}
			}
		}
		
		if (s.size() == 1 && s.peek() == 'P')	System.out.println("PPAP");
		else									System.out.println("NP");
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_16120();
	}
}
