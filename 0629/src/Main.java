import java.io.*;
import java.util.*;

public class Main {
	
	public void sol_10844() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][10];
		
		
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				if (i == 1 && j > 0) {
					dp[i][j] = 1;
					continue;
				}
				if (j == 0)			dp[i][j] = dp[i-1][j+1] % 1000000000;
				else if (j == 9)	dp[i][j] = dp[i-1][j-1] % 1000000000;
				else 				dp[i][j] = ( dp[i-1][j+1] + dp[i-1][j-1] ) % 1000000000;
			}
		}
		
		int sum = 0;
		for (int i = 0; i <= 9; i++) {
			sum = (sum + dp[N][i]) % 1000000000;
		}
		
		System.out.println(sum);
	}
	
	public void sol_11052() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N+1];
		int[] dp = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			dp[i] = num[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j] + num[j]);
			}
		}
		
		System.out.println(dp[N]);
	}
	
	public void sol_9465() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[][] dp = new int[N+1][2];
			int[][] sticker = new int[N+1][2];
			for (int j = 0; j < 2; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 1; k <= N; k++) {
					sticker[k][j] = Integer.parseInt(st.nextToken());
				}
			} 
			dp[1] = sticker[1];
			for (int j = 2; j <= N; j++) {
				dp[j][0] = Math.max(dp[j-1][1], Math.max(dp[j-2][0], dp[j-2][1])) + sticker[j][0];
				dp[j][1] = Math.max(dp[j-1][0], Math.max(dp[j-2][0], dp[j-2][1])) + sticker[j][1];
			}
			
			sb.append(Math.max(dp[N][0], dp[N][1])).append('\n');
		}
		
		System.out.println(sb);
	}

	public static void main(String[] args) throws Exception {
		new Main().sol_9465();
	}

}
