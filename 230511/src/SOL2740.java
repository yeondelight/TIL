import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SOL2740 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public int N, M, K;
	public int[][] A, B;
	public int[][] ans;
	
	public void run() throws Exception {
		getInput();
		solution();
		print();
	}
	
	public void getInput() throws Exception {
		
		// get A
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stNM.nextToken());
		M = Integer.parseInt(stNM.nextToken());
		
		A = new int[N][M];
		for (int i = 0; i < N; i++) {
			StringTokenizer stA = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(stA.nextToken());
			}
		}
		

		// get B
		StringTokenizer stMK = new StringTokenizer(br.readLine());
		M = Integer.parseInt(stMK.nextToken());
		K = Integer.parseInt(stMK.nextToken());
		
		B = new int[M][K];
		for (int i = 0; i < M; i++) {
			StringTokenizer stB = new StringTokenizer(br.readLine());
			for (int j = 0; j < K; j++) {
				B[i][j] = Integer.parseInt(stB.nextToken());
			}
		}
	}

	public void solution() {
		ans = new int[N][K];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				for (int m = 0; m < M; m++) {
					ans[i][j] += A[i][m] * B[m][j];
				}
			}
		}
	}
	
	public void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				sb.append(ans[i][j]);
				sb.append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
