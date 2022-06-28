import java.io.*;
import java.util.*;

public class Main {

	public void sol_9657() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean[] dp = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			if (i < 6) {
				if ( i == 2 )	dp[i] = true;	// CY
				else			dp[i] = false;	// SK
			}
			else {
				if (dp[i-1] || dp[i-3] || dp[i-4])	dp[i] = false;	// SK
				else								dp[i] = true;	// CY
			}
		}
		
		if (dp[N])	System.out.println("CY");
		else		System.out.println("SK");
	}
	
	public void sol_10211() throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] dp = new int[N];
			for (int j = 0; j < N; j++) {
				dp[j] = Integer.parseInt(st.nextToken());
			}
			
			for (int j = 1; j < N; j++) {
				if (dp[j] + dp[j-1] > dp[j])	dp[j] += dp[j-1];
			}
			Arrays.sort(dp);
			sb.append(dp[N-1]).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public void sol_1912() throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dp = new int[N];
		for (int j = 0; j < N; j++) {
			dp[j] = Integer.parseInt(st.nextToken());
		}
			
		for (int j = 1; j < N; j++) {
			if (dp[j] + dp[j-1] > dp[j])	dp[j] += dp[j-1];
		}
		Arrays.sort(dp);
		System.out.println(dp[N-1]);
	}
	
	public void sol_11055() throws Exception {
		// scan
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		// cal
		int max = 0;
		int[] dp = new int[N+1];
		for (int i = 1; i <= N; i++) {
			int index = i;
			for (int j = 1; j < i; j++) {
				if (nums[j] < nums[i]) {
					if (dp[index] < dp[j]) {
						index = j;
					} // end of dp[index] < dp[j]
				} // end of nums[j] < nums[i]
			} // end of for (j)
			dp[i] = dp[index] + nums[i];
			if (max < dp[i]) {
				max = dp[i];
			}
		} // end of for (i)
		
		// print
		System.out.println(max);
	}
	
	public void sol_11722() throws Exception {
		// scan
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		// cal
		int max = 0;
		int[] dp = new int[N+1];
		for (int i = 1; i <= N; i++) {
			int index = i;
			for (int j = 1; j < i; j++) {
				if (nums[i] < nums[j]) {
					if (dp[index] < dp[j]) {
						index = j;
					} // end of dp[index] < dp[j]
				} // end of nums[j] < nums[i]
			} // end of for (j)
			dp[i] = dp[index] + 1;
			if (max < dp[i]) {
				max = dp[i];
			}
		} // end of for (i)
		
		// print
		System.out.println(max);
	}
	
	public void sol_1699() throws Exception {
		// scan
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// cal
		int[] dp = new int[N+1];
		for (int i = 1; i <= N; i++) {
			dp[i] = i;
			for (int j = 1; j*j <= i; j++) {
				if (i - j*j >= 0)
					dp[i] = dp[i] < dp[i-j*j] + 1 ? dp[i] : dp[i-j*j] + 1;
			}
		}
		
		// print
		System.out.println(dp[N]);
	}
	
	public void sol_1965() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		int[] num = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int n = Integer.parseInt(st.nextToken());
			num[i] = n;
		}
		
		int max = 0;
		for (int i = 1; i <= N; i++) {
			int index = i;
			for (int j = 1; j <= i; j++) {
				if (num[j] < num[i]) {
					if (dp[index] < dp[j]) {
						index = j;
					}
				}
			}
			dp[i] = dp[index] + 1;
			
			if (dp[i] > max)	max = dp[i];
		}
		
		System.out.println(max);
	}
	
	public void sol_15988() throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			long[] dp = new long[N+1];
			for (int j = 1; j <= N; j++) {
				if (j > 3) {
					dp[j] = (dp[j-1] + dp[j-2] + dp[j-3]) % 1000000009;
				} else {
					switch (j) {
					case 1:		dp[j] = 1;	break;
					case 2:		dp[j] = 2; 	break;
					case 3:		dp[j] = 4; 	break;
					}
				}
			}
			sb.append(dp[N]).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public void sol_15990() throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		// init
		int MAX = 100001;
		long[][] dp = new long[MAX][3];
		for (int i = 1; i < MAX; i++) {
			if (i > 3) {
				dp[i][0] = dp[i-1][1] % 1000000009 + dp[i-1][2] % 1000000009;
				dp[i][1] = dp[i-2][0] % 1000000009 + dp[i-2][2] % 1000000009;
				dp[i][2] = dp[i-3][0] % 1000000009 + dp[i-3][1] % 1000000009;
			} else {
				if (i == 1)			dp[i][0] = 1;
				else if (i == 2)	dp[i][1] = 1;
				else				dp[i][0] = dp[i][1] = dp[i][2] = 1;
			}
		}
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			long res = (dp[N][0] + dp[N][1] + dp[N][2]) % 1000000009;
			sb.append(res).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public void sol_10164() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long ways = 0;
		long[][] dp = new long[N+M+1][N+M+1];
		for (int i = 0; i <= N+M; i++) {
			for (int j = 0; j <= i; j++) {
				if (i == 0 || j == 0)	dp[i][j] = 1;
				else					dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
			}
		}
		
		if (K < 2) {		// 목적지까지의 경우의 수를 바로 찾는다. (N+M) C N
			ways = dp[N + M - 2][N - 1];
		}
		else {
			int tempN = (K % M == 0) ? K / M - 1 : K / M;
			int tempM = (K % M == 0) ? M - 1 : K % M - 1;
			ways = dp[tempN + tempM][tempM];
			
			tempN = N - tempN - 1;
			tempM = M - tempM - 1;
			ways *= dp[tempN + tempM][tempM];
		}
		
		System.out.println(ways);
	}
	
	public void sol_1932() throws Exception {
		// scan
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= i; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// cal
		int max = 0;
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i][j] += Math.max(dp[i-1][j-1], dp[i-1][j]);
			}
		}
		Arrays.sort(dp[N]);
		
		// print
		System.out.println(dp[N][N]);
	}
	
	public void sol_2156() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[N+1];
		dp[1] = num[1];
		for (int i = 1; i <= N; i++) {
			if (i > 2) {
				int drinkN = Math.max(dp[i-3] + num[i-1], dp[i-2]) + num[i];
				int nonDrinkN = dp[i-1];
				dp[i] = Math.max(drinkN, nonDrinkN);
			} else {
				switch(i) {
				case 1:	dp[i] = num[1];				break;
				case 2:	dp[i] = num[1] + num[2];	break;
				}
			}
		}
		
		System.out.println(dp[N]);
	}

	public static void main(String[] args) throws Exception{
		new Main().sol_2156();
	}
}
