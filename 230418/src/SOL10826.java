import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class SOL10826 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public int N;
	public BigInteger[] dp;
	
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
		dp = new BigInteger[N+1];
		dp[0] = BigInteger.ZERO;
		if (N != 0) {
			dp[1] = BigInteger.ONE;
		}
		
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i-1].add(dp[i-2]);
		}
	}
	
	public void print() {
		System.out.println(dp[N]);
	}
}
