import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public void sol_1437() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N < 5 ? 5 : N+1];
		
		// 0, 1, 2, 3, 4는 dp[i] = i
		for (int i = 0; i < 5; i++) {
			dp[i] = i;
		}
		
		// 그 외의 경우 3이 들어가는게 이득이다.
		for (int i = 5; i <= N; i++) {
			dp[i] = (dp[i-3] * 3) % 10007;
		}
		
		System.out.println(dp[N]);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1437();
	}

}
