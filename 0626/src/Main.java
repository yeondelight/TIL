import java.io.*;
import java.util.*;

public class Main {

	public void sol_1149() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// scan
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][3];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			dp[i][0] = Integer.parseInt(st.nextToken());
			dp[i][1] = Integer.parseInt(st.nextToken());
			dp[i][2] = Integer.parseInt(st.nextToken());
		}
		
		// cal
		for (int i = 1; i <= N; i++) {
			dp[i][0] += Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] += Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] += Math.min(dp[i-1][0], dp[i-1][1]);
		}
		
		// print
		System.out.println((int)Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
	}
	
	public void sol_11053() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] num = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		// cal
		int max = 0;
		int[] dp = new int[N+1];
		for(int i = 1; i <= N; i++) {
			int minIndex = i;
			for(int j = 1; j < i; j++) {
				if (num[j] < num[i]) {
					if (dp[minIndex] < dp[j]) {
						minIndex = j;
					}
				}
			}
			dp[i] = dp[minIndex] + 1;
			
			if (dp[i] > max) {
				max = dp[i];
			}
		}
		
		// print
		System.out.println(max);
	}
	
	public void sol_11727() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// cal
		int[] dp = new int[N+1];
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			if (i % 2 == 0)	dp[i] = (dp[i-1] * 2 + 1) % 10007;
			else			dp[i] = (dp[i-1] * 2 - 1) % 10007;
		}
		
		// print
		System.out.println(dp[N]);
	}
	
	public void sol_2193() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N+1];
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		System.out.println(dp[N]);
	}

	public static void main(String[] args) throws Exception {
		new Main().sol_2193();
	}
	
}
