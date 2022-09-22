import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public void sol_2444() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		// decrease
		for (int i = N-1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				sb.append(' ');
			}
			for (int j = 0; j < 2*(N-i)-1; j++) {
				sb.append('*');
			}
			sb.append('\n');
		}
		
		// increase
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				sb.append(' ');
			}
			for (int j = 0; j < 2*(N-i)-1; j++) {
				sb.append('*');
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
		
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2444();
	}
}
