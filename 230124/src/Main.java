import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public void sol_9507() throws Exception {
		// get fibos
		long[] fibos = new long[68];
		fibos[0] = fibos[1] = 1;
		fibos[2] = 2;
		fibos[3] = 4;
		
		for (int i = 4; i < 68; i++) {
			fibos[i] = fibos[i-1] + fibos[i-2] + fibos[i-3] + fibos[i-4];
		}
		
		// scan
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(fibos[N]).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public void sol_9656() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		if ( N % 2 == 0 )	System.out.println("SK");
		else				System.out.println("CY");
	}
	
	public void sol_13699() throws Exception {
		long[] dp = new long[36];
		dp[0] = dp[1] = 1;
		for (int i = 2; i < 36; i++) {
			for (int j = 0; j < i/2; j++) {
				dp[i] += dp[j] * dp[i-j-1];
			}
			dp[i] *= 2;
			
			if (i % 2 == 1) {
				int idx = i/2;
				dp[i] += dp[idx] * dp[idx];
			}
		}
		
		
		// scan
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(dp[N]);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_13699();
	}
}
