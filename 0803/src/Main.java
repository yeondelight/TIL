import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_2096() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
			map[i][2] = Integer.parseInt(st.nextToken());
		}
		
		// get Max
		int[][] dp = new int[N][3];
		dp[0][0] = map[0][0];
		dp[0][1] = map[0][1];
		dp[0][2] = map[0][2];
		for (int i = 1; i < N; i++) {
			dp[i][0] = map[i][0] + Math.max(dp[i-1][0], dp[i-1][1]);
			dp[i][1] = map[i][1] + Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]);
			dp[i][2] = map[i][2] + Math.max(dp[i-1][1], dp[i-1][2]);
		}
		int max = Math.max(Math.max(dp[N-1][0], dp[N-1][1]), dp[N-1][2]);
		
		// get Min
		for (int i = 1; i < N; i++) {
			dp[i][0] = map[i][0] + Math.min(dp[i-1][0], dp[i-1][1]);
			dp[i][1] = map[i][1] + Math.min(Math.min(dp[i-1][0], dp[i-1][1]), dp[i-1][2]);
			dp[i][2] = map[i][2] + Math.min(dp[i-1][1], dp[i-1][2]);
		}
		int min = Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]);
		
		System.out.println(max + " " + min);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_2096();
	}
}
