import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_14494() throws Exception {
		long DIV = 1000000007;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long[][] D = new long[N+1][M+1];
		for (int i = 1; i <= N; i++) {	// 어디든 직선으로만 뻗으면 한가지
			D[i][1] = 1;
		}

		for (int i = 1; i <= M; i++) {	// 어디든 직선으로만 뻗으면 한가지
			D[1][i] = 1;
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 2; j <= M; j++) {
				D[i][j] = D[i-1][j] + D[i][j-1] + D[i-1][j-1];
				D[i][j] %= DIV;
			}
		}
		
		System.out.println(D[N][M]);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_14494();
	}
}
