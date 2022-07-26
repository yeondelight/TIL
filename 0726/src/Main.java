import java.io.*;
import java.util.*;

public class Main {
	
	public int prec(char c) {
		switch(c) {
		case '(':	case ')':	return 0;
		case '+':	case '-':	return 1;
		case '*':	case '/':	return 2;
		default:	return -1;
		}
	}
	
	public void sol_1918() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> op = new Stack<>();
		
		String str = br.readLine();
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			switch(c) {
			case '+':
			case '-':
			case '*':
			case '/':
				while(!op.isEmpty() && (prec(c) <= prec(op.peek()))) {
					sb.append(op.pop());
				}
				op.push(c);
				break;
			case '(':
				op.push(c);
				break;
			case ')':
				char next = op.pop();
				while (next != '(') {
					sb.append(next);
					next = op.pop();
				}
				break;
			default:
				sb.append(c);
				break;
			}
		}
		
		while(!op.isEmpty()) {
			sb.append(op.pop());
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1918();
	}

}
