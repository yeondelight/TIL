import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_10942() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		boolean[][] dp = new boolean[N][N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// check palindrom
		
		// 1. init when diff == 1, 2
		for (int i = 0; i < N-1; i++) {		// i는 시작점
			dp[i][i] = dp[i+1][i+1] = true;		// 크기가 1이면 항상 펠린드롬
			dp[i][i+1] = (arr[i] == arr[i+1]);	// 크기가 2일 때 같으면 펠린드롬
		}
		
		// 2. when diff > 2
		for (int i = 2; i < N; i++) {			// i는 크기-1
			for (int j = 0; i + j < N; j++) {	// j는 시작점 (i+j는 끝점)
				// 첫값과 끝값이 같고, 중간값이 펠린드롬이어야 펠린드롬이다.
				dp[j][i+j] = (arr[j] == arr[i+j] && dp[j+1][i+j-1]);
			}
		}
		
		// Get question
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken()) - 1;
			int E = Integer.parseInt(st.nextToken()) - 1;
			if (dp[S][E])	sb.append(1);
			else			sb.append(0);
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_10942();
	}
}
