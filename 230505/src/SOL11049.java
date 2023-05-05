import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL11049 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public int N;
	public int[][] matrix;
	
	public int ans;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		
		N = Integer.parseInt(br.readLine());
		
		matrix = new int[N+1][2];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			matrix[i][0] = Integer.parseInt(st.nextToken());
			matrix[i][1] = Integer.parseInt(st.nextToken());
			
		}
	}
	
	public void solution() {
		
		if (N == 1) {
			ans = 0;
			return;
		}
		
		// dp[a][b] = a부터 b까지 곱했을 때 최소 횟수
		long[][] dp = new long[N+1][N+1];
		
		for (int i = 1; i < N; i++) {			// 구간의 크기 : i
			for (int j = 1; i+j <= N; j++) {	// 구간의 시작점 : j, 끝점 : i+j
				dp[j][i+j] = Integer.MAX_VALUE;
				for (int k = j; k < i+j; k++) {	// 중간 구분점 : k
					long val = dp[j][k] + dp[k+1][i+j];
					val += matrix[j][0] * matrix[k][1] * matrix[i+j][1];
					dp[j][i+j] = Math.min(dp[j][i+j], val);
				}
			}
		}
		
		ans = (int) dp[1][N];
	}
	
	public void print() {
		System.out.println(ans);
	}

}