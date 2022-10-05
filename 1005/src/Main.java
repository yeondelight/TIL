import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_1406() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		Stack<Character> lStack = new Stack<>();
		Stack<Character> rStack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			lStack.push(str.charAt(i));
		}

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char cmd = st.nextToken().charAt(0);
			switch(cmd) {
			case 'L':
				if (!lStack.isEmpty()) {
					rStack.push(lStack.pop());
				}
				break;
			case 'D':
				if (!rStack.isEmpty()) {
					lStack.push(rStack.pop());
				}
				break;
			case 'B':
				if (!lStack.isEmpty()) {
					lStack.pop();
				}
				break;
			case 'P':
				char c = st.nextToken().charAt(0);
				lStack.push(c);
				break;
			}
		}
		
		// print
		for (char c : lStack) sb.append(c);
		while(!rStack.isEmpty()) sb.append(rStack.pop());
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1406();
	}
}
