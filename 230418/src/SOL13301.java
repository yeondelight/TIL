import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SOL13301 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public int N;
	public long[] dp;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws IOException {
		N = Integer.parseInt(br.readLine());
	}

	public void solution() {
		
		// 초기화
		dp = new long[N+1];
		dp[1] = 1;
		
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
	}
	
	public void print() {
		long ans = 4*dp[N] + 2*dp[N-1];
		System.out.println(ans);
	}
}
