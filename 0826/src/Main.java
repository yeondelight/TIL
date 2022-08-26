import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_2493() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] top = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			top[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] res = new int[N+1];
		Stack<Integer> s = new Stack<>();
		s.push(N);
		for (int i = N-1; i > 0; i--) {
			while (!s.isEmpty() && top[s.peek()] <= top[i]) {
				res[s.pop()] = i;
			}
			s.push(i);
		}
		
		
		for (int i = 1; i <= N; i++) {
			sb.append(res[i]).append(' ');
		}
		
		System.out.println(sb);
	}
	
	public static void main (String[] args) throws Exception {
		new Main().sol_2493();
	}
}
