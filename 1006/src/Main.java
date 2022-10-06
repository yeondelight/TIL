import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public void sol_11048() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// scan
		int[][] map = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// cal
		// 0 : 가로  1 : 세로  2 : 대각선
		int[][][] dp = new int[N+1][M+1][3];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				dp[i][j][0] = Math.max(dp[i][j-1][0], Math.max(dp[i][j-1][1], dp[i][j-1][2])) + map[i][j];
				dp[i][j][1] = Math.max(dp[i-1][j][0], Math.max(dp[i-1][j][1], dp[i-1][j][2])) + map[i][j];
				dp[i][j][2] = Math.max(dp[i-1][j-1][0], Math.max(dp[i-1][j-1][1], dp[i-1][j-1][2])) + map[i][j];
			}
		}
		
		// print
		int ans = Math.max(dp[N][M][0], Math.max(dp[N][M][1], dp[N][M][2]));
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_11048();
	}
}
