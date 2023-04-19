import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL14430 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public int N, M;
	public int[][] map, dp;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws IOException, NumberFormatException {
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stNM.nextToken());
		M = Integer.parseInt(stNM.nextToken());
		
		map = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer stMap = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(stMap.nextToken());
			}
		}
	}

	public void solution() {
		dp = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				dp[i][j] += Math.max(dp[i-1][j], dp[i][j-1]) + map[i][j];
			}
		}
	}
	
	public void print() {
		System.out.println(dp[N][M]);
	}
}
