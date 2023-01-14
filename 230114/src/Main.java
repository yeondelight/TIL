import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static boolean[][] A, B;
	
	public void reverse(int x, int y) {
		for (int i = x; i < x+3; i++) {
			for (int j = y; j < y+3; j++) {
				A[i][j] = !A[i][j];
			}
		}
	}
	
	public void sol_1080() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// scan
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		A = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				A[i][j] = str.charAt(j) == '0' ? false : true;
			}
		}
		
		B = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				B[i][j] = str.charAt(j) == '0' ? false : true;
			}
		}
		
		
		// check
		int cnt = 0;
		for (int i = 0; i < N-2; i++) {
			for (int j = 0; j < M-2; j++) {
				if (A[i][j] != B[i][j]) {
					cnt++;
					reverse(i, j);
				}
			}
		}
		
		
		// A == B?
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (A[i][j] != B[i][j]) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		
		System.out.println(cnt);
	}
	public static void main(String[] args) throws Exception {
		new Main().sol_1080();
	}
}
