import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public void sol_9658() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int size = N < 5 ? 5 : N+1;
		int[] dp = new int[size];
		
		int CY = 0;
		int SK = 1;
		dp[1] = dp[3] = CY;
		dp[2] = dp[4] = SK;
		
		for (int i = 5; i <= N; i++) {
			if (dp[i-1] == SK && dp[i-3] == SK && dp[i-4] == SK) {
				dp[i] = CY;
			} else {
				dp[i] = SK;
			}
		}
		
		if (dp[N] == SK)	System.out.println("SK");
		else				System.out.println("CY");
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_9658();
	}
}
