import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SOL9625 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public int K;
	public int[][] dp;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws IOException {
		K = Integer.parseInt(br.readLine());
	}

	public void solution() {
		
		// 초기화
		// dp[i][0] = A의 개수, dp[i][1] = B의 개수
		dp = new int[K+1][2];
		dp[0][0] = 1;
		
		for (int i = 1; i <= K; i++) {
			// 모든 B는 BA가 된다. A는 B가 된다.
			// A -> 이전 값 제거. 이전의 B 값과 같음
			// B -> 이전 값 유지. 이전의 A 값 추가
			dp[i][0] = dp[i-1][1];
			dp[i][1] = dp[i-1][0] + dp[i-1][1];
		}
	}
	
	public void print() {
		System.out.println(dp[K][0] + " " + dp[K][1]);
	}
}
