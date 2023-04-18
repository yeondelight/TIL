import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL16395 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public int N, K;
	public int[][] dp;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws IOException, NumberFormatException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
	}

	public void solution() {
		dp = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			dp[i][1] = dp[i][i] = 1;
			for (int j = 2; j < i; j++) {
				dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
			}
		}
	}
	
	public void print() {
		System.out.println(dp[N][K]);
	}
}
