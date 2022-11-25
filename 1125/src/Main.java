import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public void sol_2720() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int Q = 25;
		int D = 10;
		int N = 5;
		int P = 1;
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int C = Integer.parseInt(br.readLine());
			int q = C / Q;
			C %= Q;
			int d = C / D;
			C %= D;
			int n = C / N;
			C %= N;
			int p = C / P;
			sb.append(q).append(' ').append(d).append(' ').append(n).append(' ').append(p);
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2720();
	}
}
