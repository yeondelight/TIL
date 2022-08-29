import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_17298() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		int[] NGE = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			NGE[i] = -1;
		}
		
		Stack<Integer> s = new Stack<>();
		s.push(0);
		
		for (int i = 1; i < N; i++) {
			while (!s.isEmpty() && num[s.peek()] < num[i]) {
				NGE[s.pop()] = num[i];
			}
			s.push(i);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(NGE[i]).append(' ');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_17298();
	}
}
