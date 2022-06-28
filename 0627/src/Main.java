import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;

public class Main {

	public void sol_14501() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] val = new int[N+1][2];
		int[] dp = new int[N+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			val[i][0] = T;
			val[i][1] = P;
			dp[i] = P;
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				if (i - j >= val[j][0]) {
					dp[i] = Math.max(val[i][1] + dp[j], dp[i]);
				}
			}
		}
		
		int max = 0;
		for (int i = 1; i <= N; i++) {
			if (i + val[i][0] <= N + 1 && max < dp[i]) {
				max = dp[i];
			}
		}
		
		System.out.println(max);
	}
	
	public void sol_1904() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 15746;
		}
		System.out.println(dp[N]);
	}
	
	public void sol_11051() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N+1][N+1];
		
		for(int i = 0; i <= N; i++) {
			for(int j = 0; j <= i; j++) {
				if (i == 0 || j == 0)	dp[i][j] = 1;
				else					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10007;
			}
		}
		
		System.out.println(dp[N][K]);
	}
	
	public void sol_2407() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		BigInteger[][] dp = new BigInteger[N+1][N+1];
		
		for(int i = 0; i <= N; i++) {
			for(int j = 0; j <= N; j++) {
				if (j > i) {
					dp[i][j] = BigInteger.ZERO;
				}
				else if (i == 0 || j == 0) {
					dp[i][j] = BigInteger.ONE;
				}
				else {
					dp[i][j] = dp[i-1][j-1].add(dp[i-1][j]);
				}
			}
		}
		
		System.out.println(dp[N][M]);
	}
	
	public void sol_2491() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] num = new int[N+1];
		int[][] dp = new int[2][N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)	num[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 2; i <= N; i++) {
			if (num[i-1] <= num[i])	dp[0][i] = dp[0][i-1] + 1;
			if (num[i-1] >= num[i])	dp[1][i] = dp[1][i-1] + 1;
		}
		Arrays.sort(dp[0]);
		Arrays.sort(dp[1]);
		int res = dp[0][N] < dp[1][N] ? dp[1][N] + 1 : dp[0][N] + 1;
		
		System.out.println(res);
	}
	
	public void sol_2670() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		BigDecimal[] dp = new BigDecimal[N+1];
		BigDecimal max = BigDecimal.ZERO;
		
		for (int i = 1; i <= N; i++) {
			dp[i] = new BigDecimal(br.readLine());
		}
		
		for (int i = 2; i <= N; i++) {
			if (dp[i].multiply(dp[i-1]).compareTo(dp[i]) > 0)
					dp[i] = dp[i].multiply(dp[i-1]);
			if (dp[i].compareTo(max) > 0)
				max = dp[i];
		}
		
		System.out.println(max.setScale(3, RoundingMode.HALF_DOWN));
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2670();
	}
}
