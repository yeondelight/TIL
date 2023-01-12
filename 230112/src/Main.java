import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Main {
	
	public void sol_9009() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// get Prime
		ArrayList<Integer> fibos = new ArrayList<>();
		int MAX = 1000000000;
		int prev0 = 0;
		int prev1 = 1;
		int curr = prev0 + prev1;
		do {
			fibos.add(curr);
			prev0 = prev1;
			prev1 = curr;
			curr = prev0 + prev1;
		} while (curr < MAX);
		
		Collections.reverse(fibos);
		
		// scan
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			Stack<Integer> stack = new Stack<>();
			for (int f : fibos) {
				if (f <= n && n-f >= 0) {
					stack.push(f);
					n -= f;
				}
				if (n == 0) {
					break;
				}
			}
			
			while(!stack.isEmpty()) {
				sb.append(stack.pop()).append(' ');
			}
			sb.append('\n');
		}
		
		
		// print
		System.out.println(sb);		
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_9009();
	}
}
