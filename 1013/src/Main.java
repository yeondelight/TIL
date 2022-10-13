import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_1890() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		long[][] dp = new long[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = 1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int val = map[i][j];
				if (dp[i][j] == 0 || val == 0)
					continue;
				if (i + val < N)	dp[i+val][j] += dp[i][j];
				if (j + val < N)	dp[i][j+val] += dp[i][j];
			}
		}
		
		System.out.println(dp[N-1][N-1]);
		
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1890();
	}

}
