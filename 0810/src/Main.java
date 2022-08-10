import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N;
	
	public long[][] multiply(long[][] m1, long[][] m2) {
		long[][] res = new long[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					res[i][j] += m1[i][k] * m2[k][j];
					res[i][j] %= 1000;
				}
			}
		}
		return res;
	}
	
	
	public long[][] conquer(long[][] A, long B) {
		if (B == 1) {
			return A;
		}
		else {
			long[][] divMod = conquer(A, B/2);
			if (B % 2 == 0) {
				return multiply(divMod, divMod);				// return divMod * divMod
			} else {
				return multiply(divMod, multiply(divMod, A));	// return divMod * divMod * A
			}
		}
	}
	
	public void sol_10830() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		long[][] A = new long[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Long.parseLong(st.nextToken()) % 1000;
			}
		}
		
		long[][] res = conquer(A, B);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(res[i][j]).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_10830();
	}
}
