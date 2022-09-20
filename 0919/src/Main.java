import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_2294() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int MAX = 10001;
		int[] coins = new int[n];
		int[] dp = new int[k+1];
		
		for (int i = 0; i <= k; i++) {
			dp[i] = MAX;
		}
		
		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < n; i++) {
			if (coins[i] > k) {
				continue;
			}
			dp[coins[i]] = 1;
			for (int j = coins[i]; j <= k; j++) {
				dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1);
			}
		}
		
		System.out.println(dp[k] >= MAX ? -1 : dp[k]);
	}

	public static void main(String[] args) throws Exception {
		new Main().sol_2294();
	}
}
