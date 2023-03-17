import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_6591() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = 0, K = 0;
		
		while (true) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			if (N == 0 && K == 0) {
				break;
			}
			
			K = Math.min(K, N-K);
			
			long ans = 1;
			for (long i = N, j = 1; j <= K; i--, j++) {
				ans *= i;
				ans /= j;
			}
			
			sb.append(ans).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_6591();
	}
}
