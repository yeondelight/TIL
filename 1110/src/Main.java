import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	
	public void sol_14916() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int [n+1 < 6 ? 6 : n+1];
		
		dp[2] = dp[5] = 1;
		dp[4] = 2;
		
		for (int i = 6; i <= n; i++) {
			if (dp[i-2] != 0 && dp[i-5] != 0) {
				dp[i] = Math.min(dp[i-5], dp[i-2]) + 1;
			} else if (dp[i-2] == 0 && dp[i-5] != 0) {
				dp[i] = dp[i-5] + 1;
			} else if (dp[i-2] != 0 && dp[i-5] == 0) {
				dp[i] = dp[i-2] + 1;
			}
		}
		
		System.out.println(dp[n] == 0 ? -1 : dp[n]);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_14916();
	}
}
