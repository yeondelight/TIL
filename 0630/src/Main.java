import java.io.*;
import java.util.*;

public class Main {
	
	public void sol_12865() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] W = new int[N+1];
		int[] V = new int[N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		int[][] dp = new int[N+1][K+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if (W[i] <= j)	dp[i][j] = Math.max(V[i] + dp[i-1][j-W[i]], dp[i-1][j]);
				else			dp[i][j] = dp[i-1][j];
				max = Math.max(dp[i][j], max);
			}
		}
		
		System.out.println(max);
	}
	
	public void sol_9251() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		int max = 0;
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];
		for (int i = 1; i <= str1.length(); i++) {
			char c1 = str1.charAt(i-1);
			for (int j = 1; j <= str2.length(); j++) {
				char c2 = str2.charAt(j-1);
				if (c1 == c2)	dp[i][j] = dp[i-1][j-1] + 1;
				else			dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				max = Math.max(dp[i][j], max);
			}
		}
		
		System.out.println(max);
	}
	
	public void sol_11057() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N+1][10];
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				if (j > 0 && i > 1) {
					dp[i][j] = ( dp[i-1][j] + dp[i][j-1] ) % 10007;
				} else {
					dp[i][j] = 1;
				}
			}
		}
		
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum = (sum + dp[N][i]) % 10007;
		}
		
		System.out.println(sum);
	}
	
	public void sol_2293() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coin = new int[N+1];
		for (int i = 1; i <= N; i++) 	coin[i] = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N+1][K+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= K; j++) {
				if (j == 0)				dp[i][j] = 1;
				else if (j < coin[i])	dp[i][j] = dp[i-1][j];
				else 					dp[i][j] = dp[i-1][j] + dp[i][j-coin[i]];
			}
		}
		
		System.out.println(dp[N][K]);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2293();
	}
}
