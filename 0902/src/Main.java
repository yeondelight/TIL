import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public void sol_6198() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[] num = new long[N];
		for (int i = 0; i < N; i++) {
			num[i] = Long.parseLong(br.readLine());
		}
		
		long[] count = new long[N];
		Stack<Integer> s = new Stack<>();
		s.push(N-1);
		for (int i = N-2; i >= 0; i--) {
			while (!s.isEmpty() && num[s.peek()] < num[i]) {
				count[i] += count[s.peek()] + 1;
				s.pop();
			}
			s.push(i);
		}
	
		long sum = 0;
		for (int i = 0; i < N; i++) {
			sum += count[i];
		}
		
		System.out.println(sum);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_6198();
	}
}
