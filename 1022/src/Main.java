import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public void sol_17413() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String S = br.readLine();
		
		boolean isTag = false;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < S.length(); i++) {
			char curr = S.charAt(i);
			switch (curr) {
			case '<':
				isTag = true;					// tag open
				while (!stack.isEmpty()) {		// 앞에 나온 내용 제거
					sb.append(stack.pop());
				}
				stack.push(curr);				// push '<'
				break;
			case '>':
				isTag = false;					// tag close
				Stack<Character> tempStack = new Stack<>();
				while (stack.peek() != '<') {	// move tags
					tempStack.push(stack.pop());
				}
				stack.pop();
				sb.append('<');
				while (!tempStack.isEmpty()) {
					sb.append(tempStack.pop());
				}
				sb.append('>');
				break;
			case ' ':
				if (!isTag) {
					while (!stack.isEmpty()) {
						sb.append(stack.pop());
					}
					sb.append(' ');
				} else {
					stack.push(curr);
				}
				break;
			default:
				stack.push(curr);
				break;
			}
		}
		
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_17413();
	}
}
