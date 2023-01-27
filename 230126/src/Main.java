import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public void sol_15624() throws Exception {
		long[] fibo = new long[1000001];
		fibo[0] = 0;
		fibo[1] = 1;
		
		for (int i = 2; i < 1000001; i++) {
			fibo[i] = fibo[i-1] + fibo[i-2];
			fibo[i] %= 1000000007;
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(fibo[N]);
		
	}
	
	public void sol_15489() throws Exception {
		// get Combination
		int[][] comb = new int[31][31];
		for (int i = 0; i < 31; i++) {
			comb[i][0] = comb[i][i] = 1;
			for (int j = 1; j < i; j++) {
				comb[i][j] = comb[i-1][j-1] + comb[i-1][j];
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken()) - 1;	// index는 0번부터 시작
		int C = Integer.parseInt(st.nextToken()) - 1;	// index는 0번부터 시작
		int W = Integer.parseInt(st.nextToken());
		
		int cnt = 1;
		long ans = 0;
		for (int i = R; i < R+W; i++) {
			for (int j = C; j < C + cnt; j++) {
				ans += comb[i][j];
			}
			cnt++;
		}
		
		System.out.println(ans);
	}
	
	public void sol_1788() throws Exception {
		int MAX = 1000001;
		int DIV = 1000000000;
		
		long[] fibo = new long[2*MAX];
		fibo[MAX] = 0;
		fibo[MAX + 1] = 1;
		
		for (int i = MAX+2; i < 2*MAX; i++) {
			fibo[i] = fibo[i-1] + fibo[i-2];
			fibo[i] %= DIV;
		}
		
		for (int i = MAX-1; i >= 0; i--) {
			fibo[i] = fibo[i+2] - fibo[i+1];
			fibo[i] %= DIV;
		}
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		N += MAX;
		
		if (fibo[N] > 0)		System.out.println(1);
		else if (fibo[N] < 0)	System.out.println(-1);
		else					System.out.println(0);
		
		System.out.println(Math.abs(fibo[N]));
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_1788();
	}
} 
