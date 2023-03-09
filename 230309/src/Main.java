import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_13251() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		
		int N = 0;
		int[] stone = new int[M];
		StringTokenizer stStone = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			stone[i] = Integer.parseInt(stStone.nextToken());
			N += stone[i];
		}
		
		int K = Integer.parseInt(br.readLine());
		
		
		// 뽑는 경우의 수
		double P = 0;					
		
		for (int m = 0; m < M; m++) {
			if (stone[m] < K) {	// 2C4는 불가능
				continue;
			}
			double val = 1;
			for (int i = stone[m], j = K; j > 0; i--, j--) {
				val *= (double) i / j;
			}
			P += val;
		}
		
		// 전체 경우의 수
		double T = 1;
		for (int i = N, j = K; j > 0; i--, j--) {
			T *= (double) i / j;
		}
		
		
		// print
		System.out.println(P/T);
	}

	public void sol_16922() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int MAX = 1001;
		int[] num = {1, 5, 10, 50};
		
		int N = Integer.parseInt(br.readLine());
		boolean[] check = new boolean[MAX];
		
		int cnt = 0;

		for (int a = 0; a <= N; a++) {
			for (int b = 0; b <= N-a; b++) {
				for (int c = 0; c <= N-a-b; c++) {
					int d = N-a-b-c;
					int val = a*num[0] + b*num[1] + c*num[2] + d*num[3];
					if (!check[val]) {
						check[val] = true;
						cnt++;
					}
				}
			}
		}
		
		System.out.println(cnt);
	}

	public static void main(String[] args) throws Exception {
		new Main().sol_16922();
	}
}
