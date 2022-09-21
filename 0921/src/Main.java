import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_2225() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// dp[i][j]는 i을 j개의 정수로 나타낸 가짓수
		int[][] dp = new int[N+1][K+1];
		for (int i = 0; i <= N; i++) {
			dp[i][1] = 1;
		}
		
		// DP[N][K] = Σ(DP[N-L][K-1])
		for (int i = 0; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				for (int l = 0; l <= i; l++) {
					dp[i][j] += dp[l][j-1];
					dp[i][j] %= 1000000000;
				}
			}
		}
		
		// 출력
		System.out.println(dp[N][K]);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2225();
	}
}
